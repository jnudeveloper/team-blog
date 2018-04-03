package org.jchy.domain.po;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BasePO implements Serializable {

	private static final long serialVersionUID = -6773063240221835661L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	/** 记录创建时间 */
	@Column(name = "createt_time")
	protected Date createTime;

	/** 记录修改时间 */
	@Column(name = "update_time")
	protected Date updateTime;
	
	/** 删除标志 */
	@Column(name = "delete_flag")
	protected Integer deleteFlag;

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
	
}
