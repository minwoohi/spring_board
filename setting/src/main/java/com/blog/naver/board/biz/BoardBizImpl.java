package com.blog.naver.board.biz;


import com.blog.naver.board.dao.BoardDao;
import com.blog.naver.board.vo.BoardListVO;
import com.blog.naver.board.vo.BoardSearchVO;
import com.blog.naver.board.vo.BoardVO;

public class BoardBizImpl implements BoardBiz{
	private BoardDao boardDao;

	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}


	@Override
	public BoardListVO getAllArticles(BoardSearchVO boardSearchVO) {
		/*
		 * 	BoardListVO
		 * 		Pager
		 * 			endArticleNumber
		 * 			startArticleNumber
		 * 			pageNo
		 * 			totalArticleCount
		 * 
		 * 	BoardSearchVO
		 * 		endArticleNumber
		 * 		startArticleNumber
		 * 		pageNo
		 * */
		
		int totalCount = boardDao.getAllArticlesCount(boardSearchVO);
		
		BoardListVO boardListVO = new BoardListVO();
		boardListVO.getPager().setPageNumber(boardSearchVO.getPageNo());
		boardListVO.getPager().setTotalArticleCount(totalCount);
		
		boardSearchVO.setEndArticleNumber(boardListVO.getPager().getEndArticleNumber());
		boardSearchVO.setStartArticleNumber(boardListVO.getPager().getStartArticleNumber());
		
		if(totalCount == 0){
			return boardListVO;
		}
		
		boardListVO.setBoardList(boardDao.getAllArticles(boardSearchVO));
		
		return boardListVO;
	}

	@Override
	public BoardVO getOneBoard(int boardId) {
		return boardDao.selectOneArticle(boardId);
	}

	@Override
	public boolean addOneBoard(BoardVO board) {
		return boardDao.insertOneArticle(board) > 0;
	}
	
	@Override
	public boolean removeOneBoard(int boardId) {
		return boardDao.deleteOneArticle(boardId) > 0;
	}
	
}
