package com.blog.naver.board.dao;

import java.util.List;

import com.blog.naver.board.vo.BoardSearchVO;
import com.blog.naver.board.vo.BoardVO;

public interface BoardDao {

	public int getAllArticlesCount(BoardSearchVO boardSearchVO);
	
	public List<BoardVO> getAllArticles(BoardSearchVO boardSearchVO);
	
	public int insertOneArticle(BoardVO boardVO);
	
	public int deleteOneArticle(int boardId);

	public BoardVO selectOneArticle(int boardId);
	
}