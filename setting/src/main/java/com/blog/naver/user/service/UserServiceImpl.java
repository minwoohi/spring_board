package com.blog.naver.user.service;

import com.blog.naver.user.biz.UserBiz;
import com.blog.naver.user.vo.UserVO;

public class UserServiceImpl implements UserService{

	private UserBiz userBiz;
	
	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}
	
	@Override
	public boolean addUser(UserVO usersVO) {
		return userBiz.addUser(usersVO);
	}

	@Override
	public UserVO getOneUser(UserVO userVO) {
		return userBiz.getOneUser(userVO);
	}

}
