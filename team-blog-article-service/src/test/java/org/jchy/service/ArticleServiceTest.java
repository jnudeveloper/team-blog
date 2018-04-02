package org.jchy.service;

import java.util.List;

import org.jchy.domain.dto.ArticleDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceTest {

	@Autowired
	private ArticleService articleService;

	@Test
	public void testGetArticle() throws Exception {
		ArticleDTO articleDTO = articleService.getArticleAndIncrReadNum(1L);
		System.out.println(articleDTO);
		Assert.assertEquals("article1", articleDTO.getTitle());
	}

	@Test
	public void testListArticlesByAuthorId() throws Exception {
		List<ArticleDTO> articleDTOs = articleService.listArticlesByAuthorId(1L, 0, 10, false);
		System.out.println(articleDTOs);
	}
	
}
