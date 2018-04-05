package org.jchy.service;

import org.jchy.bean.PageBean;
import org.jchy.domain.dto.CommentDTO;

public interface CommentService {

	/**
	 * 根据文章id获取多条评论，分页10
	 * 
	 * @param id
	 * @return
	 */
	PageBean<CommentDTO> listPagedCommentsByArticleId(Long articleId, int offset);

	void saveComment(CommentDTO commentDTO) throws Exception;
	
}
