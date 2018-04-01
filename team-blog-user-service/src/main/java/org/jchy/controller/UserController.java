package org.jchy.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	/**
	 * Remote Call Demo
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping("/{userId}")
	public String user(@PathVariable("userId") Long userId) {
		System.out.println("provider worked!");
		return "Remote Call: " + "getUsernameByUserId(" + userId + ")";
	}

}
