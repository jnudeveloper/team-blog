package org.jchy.domain.po;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_article")
public class Article extends BasePO {

	private static final long serialVersionUID = 1614698968631343661L;

	/** 文章内容 */
	private String content;

	/** 文章标题 */
	private String title;

	/** 摘要 */
	private String summary;

	/** 作者用户的id */
	@Column(name = "author_id")
	private Long authorId;

	/** 文章状态 */
	private Integer status;

	/** 访问次数 */
	@Column(name = "read_num")
	private Integer readNum;

	/** 点赞次数 */
	@Column(name = "like_num")
	private Integer likeNum;

	/** 评论次数 */
	@Column(name = "comment_num")
	private Integer commentNum;

	/** 优先级 */
	private Integer order;

	/** 发布时间 */
	@Column(name = "post_time")
	private Date postTime;

	@ManyToMany(targetEntity = Tag.class, fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "tb_article_tag",
			   joinColumns = @JoinColumn(name = "article_id"), 
			   inverseJoinColumns = @JoinColumn(name = "tag_id"))
	private Set<Tag> tagSet = new HashSet<>();
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getSummary() {
		return summary;
	}


	public void setSummary(String summary) {
		this.summary = summary;
	}


	public Long getAuthorId() {
		return authorId;
	}


	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public Integer getReadNum() {
		return readNum;
	}


	public void setReadNum(Integer readNum) {
		this.readNum = readNum;
	}


	public Integer getLikeNum() {
		return likeNum;
	}


	public void setLikeNum(Integer likeNum) {
		this.likeNum = likeNum;
	}


	public Integer getCommentNum() {
		return commentNum;
	}


	public void setCommentNum(Integer commentNum) {
		this.commentNum = commentNum;
	}


	public Integer getOrder() {
		return order;
	}


	public void setOrder(Integer order) {
		this.order = order;
	}


	public Date getPostTime() {
		return postTime;
	}


	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}


	public Set<Tag> getTagSet() {
		return tagSet;
	}


	public void setTagSet(Set<Tag> tagSet) {
		this.tagSet = tagSet;
	}

	@Override
	public String toString() {
		return "Article [content=" + content + ", title=" + title + ", summary=" + summary + ", authorId=" + authorId
				+ ", status=" + status + ", readNum=" + readNum + ", likeNum=" + likeNum + ", commentNum=" + commentNum
				+ ", order=" + order + ", postTime=" + postTime + ", tagSet=" + tagSet + ", id=" + id + ", createTime="
				+ createTime + ", updateTime=" + updateTime + ", deleteFlag=" + deleteFlag + "]";
	}
	
}
