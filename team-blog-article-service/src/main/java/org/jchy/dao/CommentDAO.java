package org.jchy.dao;

import org.jchy.domain.po.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface CommentDAO extends JpaRepository<Comment, Long> , QuerydslPredicateExecutor<Comment>{

}
