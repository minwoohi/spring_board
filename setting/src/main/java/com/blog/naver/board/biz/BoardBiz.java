package com.blog.naver.board.biz;

import com.blog.naver.board.vo.BoardListVO;
import com.blog.naver.board.vo.BoardSearchVO;
import com.blog.naver.board.vo.BoardVO;

public interface BoardBiz {
	
	public BoardListVO getAllArticles(BoardSearchVO boardSearchVO);
	
	public BoardVO getOneBoard(int boardId);
	
	public boolean removeOneBoard(int boardId);
	
	public boolean addOneBoard(BoardVO board);
}
