package com.blog.naver.board.vo;

import java.util.List;

import com.blog.naver.common.web.Pager;
import com.blog.naver.common.web.PagerFactory;

public class BoardListVO {
	private Pager pager;
	private List<BoardVO> boardList;
	
	public Pager getPager() {
		if(pager == null){
			pager = PagerFactory.getPager(Pager.ORACLE);
		}
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public List<BoardVO> getBoardList() {
		return boardList;
	}

	public void setBoardList(List<BoardVO> boardList) {
		this.boardList = boardList;
	}
	
}
