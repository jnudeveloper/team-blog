package org.jchy.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

import org.jchy.bean.PageBean;
import org.jchy.constant.ArticleConsts;
import org.jchy.dao.ArticleDAO;
import org.jchy.domain.dto.ArticleDTO;
import org.jchy.domain.po.Article;
import org.jchy.domain.po.QArticle;
import org.jchy.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.types.Predicate;
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
	public List<ArticleDTO> listArticlesByStatus(Integer status) {
		QArticle qArticle = QArticle.article;
		List<ArticleDTO> articleDTOs = new ArrayList<>();
		
		queryFactory.select(qArticle)
		.from(qArticle)
		.where(qArticle.deleteFlag.eq(ArticleConsts.DELETED_FLAG_FALSE)
		.and(qArticle.status.eq(status)))
		.fetch()
		.forEach(a -> {
			articleDTOs.add(ArticleDTO.convertPO2DTO(a, new ArticleDTO()));
		});
		
		return articleDTOs;
	}

	@Override
	public PageBean<ArticleDTO> listPagedArticlesByStatus(Integer status, int offset, int limit) {
		QArticle qArticle = QArticle.article;
		Predicate predicate = qArticle.deleteFlag
				.eq(ArticleConsts.DELETED_FLAG_FALSE)
				.and(qArticle.status.eq(status));
		Sort sort = new Sort(Sort.Direction.ASC, "id");
		return listPagedArticlesByPredicate(predicate, offset, limit, sort);
	}
	
	@Override
	public PageBean<ArticleDTO> listPagedArticlesByAuthorIdAndStatus(
			Long authorId, 
			Integer status, 
			int offset, 
			int limit) {
		QArticle qArticle = QArticle.article;
		
		// 查询条件
		Predicate predicate = qArticle.deleteFlag
				.eq(ArticleConsts.DELETED_FLAG_FALSE)
				.and(qArticle.authorId.eq(authorId))
				.and(qArticle.status.eq(status));
		
		// 排序条件
		Sort sort = new Sort(Sort.Direction.ASC, "id");
		
		return listPagedArticlesByPredicate(predicate, offset, limit, sort);
	}

	/**
	 * attention: 充血模型的多线程问题，
	 * 
	 * 比如先读取一条记录，set属性，再update对象，此时存在线程安全问题
	 * 
	 */
	@Override
	@Transactional
	public ArticleDTO getArticleAndIncrReadNum(Long id) throws Exception {
		QArticle qArticle = QArticle.article;
		Article article = queryFactory.select(qArticle)
				.distinct()
				.from(qArticle)
				.where(qArticle.deleteFlag
				.eq(ArticleConsts.DELETED_FLAG_FALSE)
				.and(qArticle.id.eq(id))
				.and(qArticle.status.eq(ArticleConsts.STATUS_PUBLIC)))
				.fetchOne();

		if (article == null)
			throw new Exception(); // TODO: 异常规划
		
		articleDAO.increaseReadNum(id); // 更新阅读量，db行级锁，线程安全

		return ArticleDTO.convertPO2DTO(article, new ArticleDTO());
	}

	@Override
	public List<ArticleDTO> listArticlesByTagNameAndStatus(String tagName, Integer status) {
		QArticle qArticle = QArticle.article;
		
		List<ArticleDTO> articleDTOs = new ArrayList<>();
		
		Predicate predicate = qArticle.deleteFlag
				.eq(ArticleConsts.DELETED_FLAG_FALSE)
				.and(qArticle.status.eq(ArticleConsts.STATUS_PUBLIC));
		
		articleDAO.findAll(predicate).forEach(a -> {
			articleDTOs.add(ArticleDTO.convertPO2DTO(a, new ArticleDTO()));
		});
		
		return articleDTOs;
	}

	/**
	 * 抽取公共方法
	 * 
	 * @param predicate
	 * @param offset
	 * @param limit
	 * @param sort
	 * @return
	 */
	private PageBean<ArticleDTO> listPagedArticlesByPredicate(
			Predicate predicate, 
			int offset, 
			int limit,
			Sort sort) {
		List<ArticleDTO> articleDTOs = new ArrayList<>();
		
		// 得到结果为PageRequest对象
		Page<Article> articles = articleDAO.findAll(predicate, PageRequest.of(offset, limit, sort));
		
		// 将PageRequest内部的po list转成 dto list
		articles.stream().forEach(a -> {
			articleDTOs.add(ArticleDTO.convertPO2DTO(a, new ArticleDTO()));
		});
		
		return new PageBean<ArticleDTO>(
				articleDTOs, 
				articles.getNumber(), 
				articles.getSize(), 
				articles.getTotalPages());
	}
	
}
