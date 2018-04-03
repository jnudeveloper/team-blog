package org.jchy.controller;

import org.jchy.bean.Response;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 页面入口
 * 
 * @author Jeremy
 * @date 2018年4月3日
 *
 */
public class IndexController {
	
	/**
	 * 文章存档
	 * 
	 * @return
	 */
	@GetMapping("/archives")
	public Response archives() {
		return null; // TODO
	}
	
	/**
	 * 显示所有标签
	 * 
	 * @return
	 */
	@GetMapping("/tags")
	public Response tags() {
		return null; // TODO
	}
	
}
