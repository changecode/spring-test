package com.springmybatis.model;

import java.io.Serializable;

/**
 * user domain
 * 
 * @author Tim
 *
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String headimg;
	private Integer isdeleted;
	private String name;
	private String password;
	private String phonenum;
	private String usertype;
	private String openid;

	// 方便测试时用到
	@Override
	public String toString() {
		return "User [id=" + id + ", headimg=" + headimg + ", isdeleted=" + isdeleted + ", name=" + name + ", password="
				+ password + ", phonenum=" + phonenum + ", usertype=" + usertype + ", openid=" + openid + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHeadimg() {
		return headimg;
	}

	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}

	public Integer getIsdeleted() {
		return isdeleted;
	}

	public void setIsdeleted(Integer isdeleted) {
		this.isdeleted = isdeleted;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

}