package org.jchy.service;

import java.util.List;

import org.jchy.domain.dto.ArticleDTO;
import org.jchy.domain.dto.CommentDTO;

/**
 * 
 * @author Jeremy
 * @date 2018年4月2日
 *
 */
public interface ArticleService {

	/**
	 * 毫无保留地展示所有文章
	 * 
	 * @return
	 */
	List<ArticleDTO> listArticles();
	
	/**
	 * 根据用户id获取多条文章，分页默认10，按时间降序，需要注意状态位
	 * 
	 * @param authorId
	 * @param offset
	 * @param limit
	 * @param isDeleted
	 * @return
	 */
	List<ArticleDTO> listArticlesByAuthorId(Long authorId, int offset, int limit, boolean isDeleted);

	/**
	 * 根据文章id获取单条文章，同时更新阅读数
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	ArticleDTO getArticleAndIncrReadNum(Long articleId) throws Exception;

	/**
	 * 根据文章id获取多条评论，分页10
	 * 
	 * @param id
	 * @return
	 */
	List<CommentDTO> listComments(Long articleId, int offset);

}
