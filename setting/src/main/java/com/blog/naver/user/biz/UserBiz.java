package com.blog.naver.user.biz;

import com.blog.naver.user.vo.UserVO;

public interface UserBiz {

	public boolean addUser(UserVO usersVO);

	public UserVO getOneUser(UserVO userVO);

}
