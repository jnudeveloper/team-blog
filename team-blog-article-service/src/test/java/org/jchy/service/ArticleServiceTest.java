package org.jchy.service;

import static org.junit.Assert.fail;

import java.util.List;

import javax.transaction.Transactional;

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
	ArticleService articleService;
	
	@Test
	public void testListArticlesByStatus() {
		fail("Not yet implemented");
	}

	@Test
	public void testListPagedArticlesByStatus() {
		fail("Not yet implemented");
	}

	@Test
	public void testListPagedArticlesByAuthorIdAndStatus() {
		fail("Not yet implemented");
	}

	/**
	 * 需加上@Transactional，否则延迟加载失败
	 */
	@Test
	@Transactional
	public void testListArticlesByTagNameAndStatus() {
		List<ArticleDTO> articleDTOs = articleService.listArticlesByTagNameAndStatus("tag1", 1);
		Assert.assertEquals(2, articleDTOs.size());
	}

	@Test
	public void testGetArticleAndIncrReadNum() {
		fail("Not yet implemented");
	}

}
