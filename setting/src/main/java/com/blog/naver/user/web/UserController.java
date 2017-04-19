package com.blog.naver.user.web;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.blog.naver.user.service.UserService;
import com.blog.naver.user.vo.UserVO;

@Controller
public class UserController {

	private UserService userService;
	private Logger logger = LoggerFactory.getLogger(UserController.class);

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/user/signUp", method = RequestMethod.GET)
	public String viewSignUpPage() {
		return "user/signUp";
	}

	@RequestMapping(value = "/user/signUp", method = RequestMethod.POST)
	public String doSignUpPage(@Valid @ModelAttribute("signUpForm") UserVO user, Errors errors) {
		
		if (errors.hasErrors()) {
			return "/user/signUp";
		} else {
			if (userService.addUser(user)) {
				return "redirect:/user/signIn";
			} else {
				return "redirect:/user/signUp";
			}
		}
	}
	
	
	@RequestMapping(value = "/user/signIn", method = RequestMethod.GET)
	public String viewSignInPage() {
		logger.info("/user/signIn");
		return "user/signIn";
	}

	@RequestMapping(value = "/user/signIn", method = RequestMethod.POST)
	public String doSignInPage(@Valid @ModelAttribute("signInForm") UserVO user, Errors errors, HttpSession session) {
		logger.info("userId : " +user.getUserId());
		logger.info("userPassword : " + user.getUserPassword());
		
		if(errors.getErrorCount() > 1){ // error가 존재한다면
			logger.info("getErrorCount > 1");
			return "/user/signIn";
		} else { // error가 1개인 경우
			user = userService.getOneUser(user);
			if(user != null){
				session.setAttribute("_USER_", user);
				return "redirect:/board/list";
			} else {
				return "redirect:/user/signIn";
			}
		}
		
		/*logger.info("/user/signIn post");
		if (userService.getOneUser(user) != null) {
			logger.info("user 찾음");
			session.setAttribute("_USER_", user);
			return "redirect:/board/list";
		} else {
			logger.info("user 못찾음");
			return "redirect:/user/signIn";
		}*/
		
	}
}
