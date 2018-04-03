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

import com.querydsl.jpa.impl.JPAQueryFactory;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleDAO articleDAO;

	@Autowired
	private EntityManager entityManager;

	private JPAQueryFactory queryFactory;

	@PostConstruct
	public void init() {
		queryFactory = new JPAQueryFactory(entityManager);
	}

	@Override
	public List<ArticleDTO> listArticles() {
		List<Article> articles = articleDAO.findAll();
		List<ArticleDTO> articleDTOs = new ArrayList<ArticleDTO>();
		articles.forEach(a -> {
			articleDTOs.add(ArticleDTO.convertPO2DTO(a, new ArticleDTO()));
		});
		return articleDTOs;
	}

	@Override
	public List<ArticleDTO> listArticlesByAuthorId(Long authorId, int offset, int limit, boolean isDeleted) {
		QArticle qArticle = QArticle.article;
		List<ArticleDTO> articleDTOs = new ArrayList<>();

		queryFactory.select(qArticle)
					.from(qArticle)
					.where(qArticle.deleteFlag.eq(isDeleted ? 1 : 0)
					.and(qArticle.authorId.eq(authorId)))
					.orderBy(qArticle.id.asc())
					.offset(offset)
					.limit(limit)
					.fetchResults()
					.getResults()
					.forEach(a -> {
						articleDTOs.add(ArticleDTO.convertPO2DTO(a, new ArticleDTO()));
					});
		
		return articleDTOs;
	}

	/**
	 * attention: 充血模型的多线程问题，
	 * 
	 * 比如先读取一条记录，set属性，再update对象，此时存在线程安全问题
	 * 
	 * TODO: 查询还需要加入状态条件，而不是简单地根据id查
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
	public List<CommentDTO> listComments(Long articleId, int offset) {
		// TODO Auto-generated method stub
		return null;
	}

}
