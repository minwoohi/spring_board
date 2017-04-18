package com.blog.naver.user.dao;

import com.blog.naver.user.vo.UserVO;

public interface UserDao {

	int insertNewUser(UserVO usersVO);

	UserVO selectOneUser(UserVO userVO);

}
