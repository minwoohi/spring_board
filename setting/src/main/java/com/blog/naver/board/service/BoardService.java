package com.blog.naver.board.service;

import com.blog.naver.board.vo.BoardListVO;
import com.blog.naver.board.vo.BoardSearchVO;
import com.blog.naver.board.vo.BoardVO;

public interface BoardService {
	
	public BoardListVO getAllArticles(BoardSearchVO boardSearchVO);
	
	public BoardVO getOneBoard(int boardId);
	
	public boolean addOneBoard(BoardVO board);
	
	public boolean removeOneBoard(int boardId);

}
