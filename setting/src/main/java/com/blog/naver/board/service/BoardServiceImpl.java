package com.blog.naver.board.service;

import com.blog.naver.board.biz.BoardBiz;
import com.blog.naver.board.vo.BoardListVO;
import com.blog.naver.board.vo.BoardSearchVO;
import com.blog.naver.board.vo.BoardVO;

public class BoardServiceImpl implements BoardService{

	private BoardBiz boardBiz;
	
	public void setBoardBiz(BoardBiz boardBiz) {
		this.boardBiz = boardBiz;
	}

	@Override
	public BoardListVO getAllArticles(BoardSearchVO boardSearchVO) {
		return boardBiz.getAllArticles(boardSearchVO);
	}

	@Override
	public BoardVO getOneBoard(int boardId) {
		return boardBiz.getOneBoard(boardId);
	}

	@Override
	public boolean addOneBoard(BoardVO board) {
		return boardBiz.addOneBoard(board);
	}
	
	@Override
	public boolean removeOneBoard(int boardId) {
		return boardBiz.removeOneBoard(boardId);
	}
	
}
