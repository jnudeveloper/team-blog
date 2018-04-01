package org.jchy.controller;

import javax.annotation.Resource;

import org.jchy.client.UserServiceCilent;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@Resource
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

}
