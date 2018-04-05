package org.jchy.service;

import java.util.List;

import org.jchy.bean.PageBean;
import org.jchy.domain.dto.ArticleDTO;

/**
 * 
 * @author Jeremy
 * @date 2018年4月2日
 *
 */
public interface ArticleService {

	/**
	 * 根据状态查询所有文章
	 * 
	 * @return
	 */
	List<ArticleDTO> listArticlesByStatus(Integer status);
	

	/**
	 * 分页查询多条文章
	 * 
	 * @param authorId
	 * @param status
	 * @param offset
	 * @param limit
	 * @return
	 */
	PageBean<ArticleDTO> listPagedArticlesByStatus(Integer status, int offset, int limit);
	
	/**
	 * 根据用户id获取多条文章，分页默认10，按时间降序，需要注意状态位
	 * 
	 * @param authorId
	 * @param offset
	 * @param limit
	 * @param isDeleted
	 * @return
	 */
	PageBean<ArticleDTO> listPagedArticlesByAuthorIdAndStatus(Long authorId, Integer status, int offset, int limit);

	/**
	 * 根据标签名查询多条文章
	 * 
	 * @param tagName
	 * @param status
	 * @return
	 */
	List<ArticleDTO> listArticlesByTagNameAndStatus(String tagName, Integer status);
	
	/**
	 * 根据文章id获取单条文章，同时更新阅读数
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	ArticleDTO getArticleAndIncrReadNum(Long id) throws Exception;

}
