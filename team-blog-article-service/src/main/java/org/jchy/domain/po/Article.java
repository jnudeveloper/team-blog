package org.jchy.domain.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.jchy.bean.BasePO;

@Entity
@Table(name = "t_article")
public class Article extends BasePO {

	private static final long serialVersionUID = 1614698968631343661L;

	public static final Integer ARTICLE_DRAFT = 0; // 草稿状态

	public static final Integer ARTICLE_POSTED_PUBLIC = 1; // 已发布，公开

	public static final Integer ARTICLE_POSTED_PRIVATE = 2; // 已发布，近私人可见

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

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

	/** 记录创建时间 */
	@Column(name = "createt_time")
	private Date createTime;

	/** 记录修改时间 */
	@Column(name = "update_time")
	private Date updateTime;
	
	/** 删除标志 */
	@Column(name = "delete_flag")
	private Integer deleteFlag;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", content=" + content + ", title=" + title + ", summary=" + summary
				+ ", authorId=" + authorId + ", status=" + status + ", readNum=" + readNum + ", likeNum=" + likeNum
				+ ", commentNum=" + commentNum + ", order=" + order + ", postTime=" + postTime + ", createTime="
				+ createTime + ", updateTime=" + updateTime + ", deleteFlag=" + deleteFlag + "]";
	}

}
