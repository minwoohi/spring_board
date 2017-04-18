package com.blog.naver.user.biz;


import com.blog.naver.user.dao.UserDao;
import com.blog.naver.user.dao.UserDaoImpl;
import com.blog.naver.user.vo.UserVO;

public class UserBizImpl implements UserBiz{

	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean addUser(UserVO usersVO) {
		return userDao.insertNewUser (usersVO) > 0;
	}

	@Override
	public UserVO getOneUser(UserVO userVO) {
		return userDao.selectOneUser(userVO);
	}

}
