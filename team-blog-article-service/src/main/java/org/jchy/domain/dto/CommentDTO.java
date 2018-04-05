package org.jchy.domain.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.jchy.domain.po.Comment;

public class CommentDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	/** 评论发起人的id */
	@Column(name = "commenter_id")
	private Long commenterId;

	/** 文章id */
	@Column(name = "article_id")
	private Long articleId;

	/** 评论发起人的名称  */
	@Column(name = "commenter_name")
	private String commenterName;
	
	/** 评论内容 */
	private String text;

	/** 父评论的id */
	@Column(name = "parent_id")
	private Long parentId;
	
	/** 是否由作者发起 */
	private Integer authorFlag;

	/** 评论发起时间 */
	private Date createTime;
	
	public static CommentDTO convertPO2DTO(Comment po, CommentDTO dto) {
		dto.setId(po.getId());
		dto.setArticleId(po.getArticleId());
		dto.setCommenterId(po.getCommenterId());
		dto.setCommenterName(po.getCommenterName());
		dto.setText(po.getText());
		dto.setCreateTime(po.getCreateTime());
		dto.setAuthorFlag(po.getAuthorFlag());
		if (dto.getParentId() != null) {
			dto.setParentId(po.getParentId());
		}
		return dto;
	}
	
	public static void convertDTO2PO(CommentDTO dto, Comment po) {
		po.setArticleId(dto.getArticleId());
		po.setCommenterId(dto.getCommenterId());
		po.setText(dto.getText());
		if (dto.getParentId() != null) {
			dto.setParentId(po.getParentId());
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCommenterId() {
		return commenterId;
	}

	public void setCommenterId(Long commenterId) {
		this.commenterId = commenterId;
	}

	public Long getArticleId() {
		return articleId;
	}

	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}

	public String getCommenterName() {
		return commenterName;
	}

	public void setCommenterName(String commenterName) {
		this.commenterName = commenterName;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Integer getAuthorFlag() {
		return authorFlag;
	}

	public void setAuthorFlag(Integer authorFlag) {
		this.authorFlag = authorFlag;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
