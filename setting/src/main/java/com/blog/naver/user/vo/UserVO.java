package com.blog.naver.user.vo;

import org.hibernate.validator.constraints.NotEmpty;

public class UserVO { // userId
	
	@NotEmpty(message="userId 입력하세요")
	private String userId;
	@NotEmpty(message="userName 입력하세요")
	private String userName;
	@NotEmpty(message="userPassword 입력하세요")
	private String userPassword;
	private String joinDate;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	
	
	
}
