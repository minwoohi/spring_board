package com.blog.naver.user.service;

import com.blog.naver.user.vo.UserVO;

public interface UserService {
	
	public boolean addUser(UserVO usersVO);

	public UserVO getOneUser(UserVO userVO);
}
