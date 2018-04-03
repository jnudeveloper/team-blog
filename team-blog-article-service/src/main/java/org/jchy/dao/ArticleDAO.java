package org.jchy.dao;

import org.jchy.domain.po.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author Jeremy
 * @date 2018年4月2日
 *
 */
@Repository
public interface ArticleDAO extends JpaRepository<Article, Long> , QuerydslPredicateExecutor<Article> {
	
	@Query(value = "update t_article a set a.read_num = a.read_num + 1 where a.id = :id", nativeQuery = true)
	@Transactional
	@Modifying(clearAutomatically = true)
	int increaseReadNum(@Param("id") Long id);

}
