package org.jchy.service;

import javax.transaction.Transactional;

import org.jchy.domain.dto.CommentDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentServiceTest {

	@Autowired
	CommentService commentService;
	
	@Test
	public void testListPagedCommentsByArticleId() {
		Assert.assertEquals(commentService.listPagedCommentsByArticleId(1L, 0).getDatas().size(), 2);
	}

	@Test
	@Transactional
	@Rollback(false)
	public void testSaveComment() throws Exception {
		CommentDTO commentDTO = new CommentDTO();
		commentDTO.setArticleId(2L);
		commentDTO.setCommenterId(1L);
		commentDTO.setText("test");
		commentService.saveComment(commentDTO);
	}

}
