package com.example.demo.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-10-24 16:11:28
 */
public class UserDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long userId;
	//用户名 渠道编号或是登录名称
	private String username;
	//密码
	private String password;
	//邮箱
	private String email;
	//手机号
	private String mobile;
	//状态 0:禁用，1:正常
	private Integer status;
	//创建用户id
	private Long userIdCreate;
	//创建时间
	private Date gmtCreate;
	//修改时间
	private Date gmtModified;
	//
	private String name;
	//所属公司或是渠道商
	private Integer departmentid;
	//所属公司或是渠道商名字
	private String departmentname;
	//0系统管理管理人员，1 渠道商管理人员，2渠道商销售人员
	private Integer persontype;

	public Integer getPersontype() {
		return persontype;
	}

	public void setPersontype(Integer persontype) {
		this.persontype = persontype;
	}

	//角色
	private List<Long> roleIds;

	public List<Long> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(List<Long> roleIds) {
		this.roleIds = roleIds;
	}

	/**
	 * 设置：
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：用户名 渠道编号或是登录名称
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：用户名 渠道编号或是登录名称
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置：密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：邮箱
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：手机号
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：手机号
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 设置：状态 0:禁用，1:正常
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态 0:禁用，1:正常
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：创建用户id
	 */
	public void setUserIdCreate(Long userIdCreate) {
		this.userIdCreate = userIdCreate;
	}
	/**
	 * 获取：创建用户id
	 */
	public Long getUserIdCreate() {
		return userIdCreate;
	}
	/**
	 * 设置：创建时间
	 */
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getGmtCreate() {
		return gmtCreate;
	}
	/**
	 * 设置：修改时间
	 */
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getGmtModified() {
		return gmtModified;
	}
	/**
	 * 设置：
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：所属公司或是渠道商
	 */
	public void setDepartmentid(Integer departmentid) {
		this.departmentid = departmentid;
	}
	/**
	 * 获取：所属公司或是渠道商
	 */
	public Integer getDepartmentid() {
		return departmentid;
	}
	/**
	 * 设置：所属公司或是渠道商名称
	 */
	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}
	/**
	 * 获取：所属公司或是渠道商名称
	 */
	public String getDepartmentname() {
		return departmentname;
	}
/*	*//**
	 * 设置：0系统管理管理人员，1 渠道商管理人员，2渠道商销售人员
	 *//*
	public void setPersontype(Integer persontype) {
		this.persontype = persontype;
	}
	*//**
	 * 获取：0系统管理管理人员，1 渠道商管理人员，2渠道商销售人员
	 *//*
	public Integer getPersontype() {
		return persontype;
	}*/
}
