package org.jchy.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

import org.jchy.dao.ArticleDAO;
import org.jchy.domain.dto.ArticleDTO;
import org.jchy.domain.dto.CommentDTO;
import org.jchy.domain.po.Article;
import org.jchy.domain.po.QArticle;
import org.jchy.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	private ArticleDAO articleDAO;
	
    @Autowired
    private EntityManager entityManager;
	
    JPAQueryFactory queryFactory;
    
    @PostConstruct
    public void init() {
        queryFactory = new JPAQueryFactory(entityManager);
    }

	@Override
	public List<ArticleDTO> listArticlesByAuthorId(Long authorId, int offset, int limit, boolean idDeleted) {
		QArticle qArticle = QArticle.article;
		QueryResults<Article> articles = queryFactory.select(qArticle)
			     .from(qArticle)
			     .where(qArticle.deleteFlag.eq(idDeleted ? 1 : 0)
			     .and(qArticle.authorId.eq(authorId)))
			     .orderBy(qArticle.id.asc()).offset(offset).limit(limit)
			     .fetchResults();
		
		List<ArticleDTO> articleDTOs = new ArrayList<>();
		for (Article a : articles.getResults()) {
			articleDTOs.add(ArticleDTO.convertPO2DTO(a, new ArticleDTO()));
		}
		
		return articleDTOs;
	}

	/**
	 * attention: 充血模型的多线程问题，
	 * 
	 * 比如先读取一条记录，set属性，再update对象，此时存在线程安全问题
	 */
	@Override
	@Transactional
	public ArticleDTO getArticleAndIncrReadNum(Long id) throws Exception {
		Optional<Article> article = articleDAO.findById(id);

		if (!article.isPresent())
			throw new Exception(); // TODO: 规划异常体系

		articleDAO.increaseReadNum(id); // 更新阅读量，db行级锁，线程安全
		
		return ArticleDTO.convertPO2DTO(article.get(), new ArticleDTO());
	}

	@Override
	public CommentDTO listComments(Long articleId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
