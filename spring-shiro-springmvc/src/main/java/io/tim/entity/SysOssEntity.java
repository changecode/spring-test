package io.tim.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 文件上传
 * Tim
 */
public class SysOssEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	//URL地址
	private String url;
	//创建时间
	private Date createDate;

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getCreateDate() {
		return createDate;
	}
}
