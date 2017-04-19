package com.blog.naver.board.dao;

import java.util.List;
import java.util.Scanner;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.blog.naver.board.vo.BoardSearchVO;
import com.blog.naver.board.vo.BoardVO;

public class BoardDaoImpl extends SqlSessionDaoSupport implements BoardDao{

	@Override
	public int getAllArticlesCount(BoardSearchVO boardSearchVO) {
		return getSqlSession().selectOne("BoardDao.getAllArticlesCount", boardSearchVO);
	}

	@Override
	public List<BoardVO> getAllArticles(BoardSearchVO boardSearchVO) {
		// namespace, id
		return getSqlSession().selectList("BoardDao.getAllArticles", boardSearchVO);
	}
	
	@Override
	public int insertOneArticle(BoardVO boardVO) {
		int count = getSqlSession().insert("BoardDao.insertOneArticle", boardVO);
		//Integer.parseInt("A");
		return count;
	}
	
	@Override
	public BoardVO selectOneArticle(int boardId) {
		return getSqlSession().selectOne("BoardDao.selectOneArticle", boardId);
	}
	
	@Override
	public int deleteOneArticle(int boardId) {
		return getSqlSession().delete("BoardDao.deleteOneArticle", boardId);
	}
}
