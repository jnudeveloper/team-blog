package org.jchy.controller;

import org.jchy.bean.Response;
import org.jchy.client.UserServiceCilent;
import org.jchy.domain.dto.ArticleDTO;
import org.jchy.domain.dto.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Jeremy
 * @date 2018年4月1日
 *
 * 注意：在gateway中设置了URL前缀拦截，所以RequestMapping绑定的URL都在"/article"根路径下
 *
 */
@RestController
public class ArticleController {

	@Autowired
	UserServiceCilent userServiceCilent;
	
	/**
	 * Remote Call Demo
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/localAndRemoteCall/{userId}", method = RequestMethod.GET)
	public String localAndRemoteCall(@PathVariable("userId") Long userId) {
		return "Local Call: getArticle(), " + userServiceCilent.username(userId);
	}

	/**
	 * 分页显示多条文章
	 * 
	 * @param offset
	 * @return
	 */
	@GetMapping("/")
	public Response listArticles(@RequestParam("offset") int offset) {
		return null; // TODO
	}

	/**
	 * 文章详情
	 * 
	 * @param aritcleId
	 * @return
	 */
	@GetMapping("/{articleId}")
	public Response getArticle(@PathVariable("aritcleId") Long aritcleId) {
		return null; // TODO
	}

	/**
	 * 新增文章
	 * 
	 * @param articleDTO
	 * @return
	 */
	@PostMapping("/article")
	public Response saveArticle(ArticleDTO articleDTO) {
		return null; // TODO
	}
	
	/**
	 * 修改文章内容、状态
	 * 
	 * @param articleDTO
	 * @return
	 */
	@PutMapping("/article/{articleId}")
	public Response updateArticle(ArticleDTO articleDTO) {
		return null; // TODO
	}
	
	/**
	 * 删除文章(逻辑删除)
	 * 
	 * @param articleDTO
	 * @return
	 */
	@DeleteMapping("/article/{articleId}")
	public Response deleteArticle(ArticleDTO articleDTO) {
		return null; // TODO
	}
	
	/**
	 * 根据标签名查找多条文章，文章为左表，多对多
	 * 
	 * @param tagName
	 * @param offset
	 * @return
	 */
	@GetMapping("/tags/{tagName}")
	public Response listArticlesByTagName(@PathVariable("tagName") String tagName) {
		return null; // TODO
	}
	
	/**
	 * 根据作者的用户id显示多条文章，单表查询
	 * 
	 * @param authorId
	 * @param offset
	 * @return
	 */
	@GetMapping("/article/u/{authorId}")
	public Response listArticlesByAuthorId(@PathVariable("authorId")Long authorId, 
			@RequestParam("offset") int offset) {
		return null;
	}
	
	/**
	 * 分页显示文章下多条评论
	 * 
	 * @param articleId
	 * @param offset
	 * @return
	 */
	@GetMapping("/article/{articleId}/comment")
	public Response listComments(@PathVariable("articleId") Long articleId,
			@RequestParam("offset") int offset) {
		return null; // TODO
	}
	
	/**
	 * 添加或回复评论
	 * 
	 * @param commentDTO
	 * @return
	 */
	@PostMapping
	public Response saveComment(CommentDTO commentDTO) {
		return null; // TODO
	}
}
