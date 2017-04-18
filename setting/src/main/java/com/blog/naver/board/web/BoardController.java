package com.blog.naver.board.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.blog.naver.board.service.BoardService;
import com.blog.naver.board.vo.BoardListVO;
import com.blog.naver.board.vo.BoardSearchVO;
import com.blog.naver.board.vo.BoardVO;
import com.blog.naver.common.DownloadUtil;
import com.blog.naver.common.web.ClassicPageExplorer;
import com.blog.naver.user.vo.UserVO;

@Controller
public class BoardController {
	private Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	private BoardService boardService;
	
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@RequestMapping("/board/list")
	public ModelAndView ViewBoardListPage(HttpSession session, BoardSearchVO boardSearchVO){
		// pageNo를 form에 전달하는 방식으로 구현된 Pager
		// boardSearchVO에 정보 저장하도록 함
		// 현재 페이지, 총 갯수 Pager에 전달되어야 함
		
		/*int pageNo = boardSearchVO.getPageNo();
		Pager pager = boardSearchVO.getPager();
		pager.setPageNumber(pageNo);*/
		// 항상 되므로 searchVO의 Setter에서 처리하는 것이 간편하다.
		
		ModelAndView view = new ModelAndView();
		
		UserVO user = (UserVO) session.getAttribute("_USER_");
		
		if(user != null){
			BoardListVO boardList = boardService.getAllArticles(boardSearchVO);
			
			view.setViewName("board/list");
			view.addObject("boardList", boardList.getBoardList());
			
			// Class 분리 이용해 한줄로 할 수 있음. AOP(?)
			ClassicPageExplorer pageExplorer = new ClassicPageExplorer(boardList.getPager());
			String pager = pageExplorer.getPagingList("pageNo", "[@]", "Prev", "Next", "searchForm");
			
			view.addObject("pager", pager);
		} else {
			view.setViewName("user/signIn");
		}
		return view;
	}
	
	@RequestMapping("/board/detail/{id}")
	public ModelAndView ViewDetailPage(@PathVariable int id, HttpSession session){
		ModelAndView view = new ModelAndView();
		
		UserVO user = (UserVO) session.getAttribute("_USER_");
		
		if(user != null){
			BoardVO board = boardService.getOneBoard(id);
			
			view.setViewName("board/detail");
			view.addObject("board", board);
			
		} else {
			view.setViewName("user/signIn");
		}
		return view;
	}
	
	@RequestMapping(value="/board/write", method=RequestMethod.GET) // 없어도 되지만 가독성
	// 향상 위해 POST 메소드 존재하는 경우 GET 사용
	public String viewWritePage(){
		return "board/write";
	}
	
	//redirect시 ModelAndView 필요 없다. String 리턴 타입으로 처리할 수 있다.
	@RequestMapping(value="/board/write", method=RequestMethod.POST) // POST 방식 지원
	public String doWriteAction(@Valid @ModelAttribute("WriteForm") BoardVO boardVO ,Errors errors, HttpServletRequest request) {
		//	BoardVO에 설정되어있는 멤버변수들의 이름과 JSP 파일의 Form에서의 이름을 똑같이 주어야한다.
		//	왜냐하면, 그렇게해야 request.getParameter()안해줘도 알아서 데이터가 들어온다.
		//	HttpSession session = request.getSession();
		
		//	실무에서는 Info / debug 많이 사용한다.
		//	logger.trace(boardVO.getSubject());
		//	logger.debug(boardVO.getSubject());
		//	logger.info(boardVO.getSubject());
		//	logger.warn(boardVO.getSubject());
		//	logger.error(boardVO.getSubject());
		
		//short circuit evaluation
		boardVO.setPost(boardVO.getFile().getOriginalFilename());
		boardVO.setIp(request.getRemoteAddr());
		logger.info("fileName : " + boardVO.getPost());
		if(boardVO.getFile() != null && !boardVO.getFile().isEmpty()){
			String filePath = "D:/uploadFiles/"
					+boardVO.getFile().getOriginalFilename();
			File newFile = new File(filePath);
			
			try{
				boardVO.getFile().transferTo(newFile);
			}catch (IllegalStateException e) {
				throw new RuntimeException(e.getMessage(),e);
			}catch (IOException e) {
				throw new RuntimeException(e.getMessage(),e);
			}
			
			if ( boardService.addOneBoard(boardVO) ){
				return "redirect:/board/list";
			}
		}
		return "redirect:/board/write";
	}
	
	@RequestMapping("/board/delete/{boardId}")
	public String doDeleteAction(@PathVariable int boardId){
		if(boardService.removeOneBoard(boardId)){
			return "redirect:/board/list";
		}
		return "/";
	}
	
	@RequestMapping("/user/signOut")
	public String doSignOut(HttpSession session){
		session.invalidate();
		return "redirect:/user/signIn";
	}
	
	@RequestMapping(value="/board/post/{boardId}", method=RequestMethod.GET)
	public void doPost(@PathVariable int boardId, HttpServletRequest request, HttpServletResponse response) throws IOException {
		BoardVO board = boardService.getOneBoard(boardId);
		logger.info("boardId : " + boardId);
		String postPath = "D:\\uploadFiles\\";
		logger.info("postPath : " + postPath);
		DownloadUtil util = DownloadUtil.getInstance(postPath);
		util.download(request, response, board.getPost(), board.getPost());
	}
}
