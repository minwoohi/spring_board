package com.blog.naver.board.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.io.File;
import java.io.FileInputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.blog.naver.user.vo.UserVO;

// url을 JUnit이 던지게 만들어 확인

@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/userContext.xml", "classpath:/applicationContext.xml", "classpath:/boardContext.xml", "classpath:/rootContext.xml"})
@WebAppConfiguration

/*
 * JUnit을 통해서 테스트하더라도 DB에 접근하지 않을 수 있다.
 * TransactionManager, TransactionAdvise, aop:config 3가지 필요
 */
@Transactional
@TransactionConfiguration(transactionManager="transactionManager")

public class BoardControllerTest {
	
	@Autowired
	private WebApplicationContext ctx;
	private MockMvc mockMvc;
	
	 // Before -> Test -> After 순으로 호출됨
	
	@Before
	public void setUp(){
		mockMvc = webAppContextSetup(ctx).build();
	}
	
	@After
	public void tearDown(){
		
	}
	
	@Test
	public void viewBoardListPageTest() throws Exception{
		
		UserVO user = new UserVO();
		user.setUserId("minwoo0414");
		user.setUserPassword("minwoo0414");
		user.setUserName("minwoo0414");
		
		mockMvc.perform(get("/board/list").sessionAttr("_USER_", user))
					.andExpect(status().isOk() )
					.andExpect(model().attributeExists("boardList"))
					.andExpect(view().name("board/list"));  // redirect는 확인 불가
		//.andExpect(redirectedUrl("/main/home");
	}
	
	@Test
	public void doWriteActionTest() throws Exception{
		// DispatcherServlet에서 모든 매개변수들 getParameter로 받아오고 스프링이 묶어주는 것뿐
		
		File f = new File("C:\\Users\\Admin\\Desktop\\20170302_180951.jpg");
		FileInputStream fis = new FileInputStream(f);
		MockMultipartFile file = new MockMultipartFile("file", f.getName() , "multipart/form-data", fis);
		// 파일 받고 있는 이름명 (VO명), 파일명, enctype, FileInputStream
		
		MockMultipartHttpServletRequestBuilder builder = fileUpload ("/board/write");
		builder.param("subject", "제목입니다...제목입니다...제목입니다...");
		builder.param("content", "내용입니다...내용입니다...내용입니다...");
		builder.param("writer", "작성자입니다...작성자입니다...");
		builder.file(file);
		
		UserVO user = new UserVO();
		user.setUserId("abc");
		user.setUserPassword("1234");
		user.setUserName("관리자");
		builder.sessionAttr("_USER_", user);
		
		// 입력할 매개변수 많은 경우 분리시켜 보기 편하게 하자.
		mockMvc.perform(builder).andExpect(model().hasNoErrors()).andExpect(status().is(302)).andExpect(redirectedUrl("/board/list"));
	}
	
}
