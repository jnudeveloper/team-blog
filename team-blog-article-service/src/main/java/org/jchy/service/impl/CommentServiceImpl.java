package org.jchy.service.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.jchy.bean.PageBean;
import org.jchy.constant.ArticleConsts;
import org.jchy.dao.CommentDAO;
import org.jchy.domain.dto.CommentDTO;
import org.jchy.domain.po.Comment;
import org.jchy.domain.po.QComment;
import org.jchy.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Service("commentService")
@Transactional
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDAO commentDAO;
	
	@Autowired
	private EntityManager entityManager;

	private JPAQueryFactory queryFactory;

	@PostConstruct
	public void init() {
		queryFactory = new JPAQueryFactory(entityManager);
	}
	
	@Override
	public PageBean<CommentDTO> listPagedCommentsByArticleId(Long articleId, int offset) {
		QComment qComment = QComment.comment;
		List<CommentDTO> commentDTOs = new ArrayList<>();
		
		Predicate predicate = qComment.articleId.eq(articleId);
		Sort sort = new Sort(Sort.Direction.ASC, "id");
		
		Page<Comment> comments = commentDAO.findAll(predicate, PageRequest.of(offset, ArticleConsts.DEFAULT_LIMIT_SIZE, sort));
		comments.stream().forEach(a -> {
			commentDTOs.add(CommentDTO.convertPO2DTO(a, new CommentDTO()));
		});
		
		return new PageBean<CommentDTO>(
				commentDTOs, 
				comments.getNumber(), 
				comments.getSize(),
				comments.getTotalPages());
	}
	
	// TODO
	@Override
	public void saveComment(CommentDTO commentDTO) throws Exception {
		Comment comment = new Comment();
		CommentDTO.convertDTO2PO(commentDTO, comment);
		
		// check comment's fields
		
		// remote call to get user info by id
		comment.setAuthorFlag(0);
		comment.setCommenterName("test");
		
		comment.setCreateTime(new Date());
		comment = commentDAO.save(comment);
		System.out.println(comment);
	}

}
