package org.jchy.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Remote Call Demo
 * @param userId
 * @return
 */
@FeignClient(value = "team-blog-user-service")
public interface UserServiceCilent {

	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	String username(@PathVariable("userId") Long userId);

}
