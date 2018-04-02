package org.jchy.domain.dto;

import java.util.Date;

import org.jchy.bean.BaseDTO;
import org.jchy.domain.po.Article;

public class ArticleDTO extends BaseDTO {

	private static final long serialVersionUID = 6887586086092428485L;

	private String content; // 内容

	private String title; // 标题

	private String summary; // 摘要

	private Long authorId; // 作者用户的id

	private Integer status; // 状态

	private Integer readNum; // 访问次数

	private Integer likeNum; // 点赞次数

	private Integer commentNum; // 评论次数

	private Date postTime; // 发布时间

	/**
	 * TODO: 重构成公共方法
	 */
	public static ArticleDTO convertPO2DTO(Article po, ArticleDTO dto) {
		dto.setId(po.getId());
		dto.setAuthorId(po.getAuthorId());
		dto.setCommentNum(po.getCommentNum());
		dto.setContent(po.getContent());
		dto.setLikeNum(po.getLikeNum());
		dto.setPostTime(po.getPostTime());
		dto.setReadNum(po.getReadNum());
		dto.setStatus(po.getStatus());
		dto.setSummary(po.getSummary());
		dto.setTitle(po.getTitle());
		return dto;
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

	public Date getPostTime() {
		return postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

	@Override
	public String toString() {
		return "ArticleDTO [content=" + content + ", title=" + title + ", summary=" + summary + ", authorId=" + authorId
				+ ", status=" + status + ", readNum=" + readNum + ", likeNum=" + likeNum + ", commentNum=" + commentNum
				+ ", postTime=" + postTime + ", id=" + id + "]";
	}
	
}
