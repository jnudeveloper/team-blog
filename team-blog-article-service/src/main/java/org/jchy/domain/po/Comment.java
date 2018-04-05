package org.jchy.domain.po;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_comment")
public class Comment implements Serializable {

	private static final long serialVersionUID = 5409850539969779977L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	/** 评论发起人的id */
	@Column(name = "commenter_id")
	private Long commenterId;

	/** 文章id */
	@Column(name = "article_id")
	private Long articleId;

	/** 评论发起人的名称，冗余字段 */
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", commenterId=" + commenterId + ", articleId=" + articleId + ", commenterName="
				+ commenterName + ", text=" + text + ", parentId=" + parentId + ", authorFlag=" + authorFlag
				+ ", createTime=" + createTime + "]";
	}
	
}
