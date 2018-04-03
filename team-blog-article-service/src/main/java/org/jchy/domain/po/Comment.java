package org.jchy.domain.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_comment")
public class Comment extends BasePO {

	private static final long serialVersionUID = 6462826635034807985L;

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

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public Integer getAuthorFlag() {
		return authorFlag;
	}

	public void setAuthorFlag(Integer authorFlag) {
		this.authorFlag = authorFlag;
	}

	@Override
	public String toString() {
		return "Comment [commenterId=" + commenterId + ", articleId=" + articleId + ", commenterName=" + commenterName
				+ ", text=" + text + ", parentId=" + parentId + ", authorFlag=" + authorFlag + ", id=" + id
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + ", deleteFlag=" + deleteFlag + "]";
	}

}
