package com.lw.mvc.core.entity;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @title : 基础实体类，包含各实体公用属性
 * @description : 
 * @time: 2017-11-01 17:38:18 
 * @author irays
 * @email  irayslu@163.com 
 * @version 0.0.5
 * @since JDK 1.7
 */
public class BaseEntity implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 创建时间
	 */
	private Date gmtCreate;
	/**
	 * 更新时间
	 */
	private Date gmtModified;
	/**
	 * 版本号
	 */
	private Long version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	

}
