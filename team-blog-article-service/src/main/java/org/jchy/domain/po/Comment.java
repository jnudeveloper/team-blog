package org.jchy.domain.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.jchy.bean.BasePO;

@Entity
@Table(name = "t_comment")
public class Comment extends BasePO {

	private static final long serialVersionUID = 2907424921164385776L;

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
	
	/** 删除标志 */
	@Column(name = "delete_flag")
	private Integer deleteFlag;

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

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

}
