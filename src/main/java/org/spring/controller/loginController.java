package org.spring.controller;


import java.util.HashMap;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.dto.PageDTO;
import org.spring.dto.loginDTO;
import org.spring.service.loginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes("pdto")
public class loginController {
	@Inject
	private loginService service;
	private static final Logger logger = LoggerFactory.getLogger(loginController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
		return "/main";
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(PageDTO pdto,loginDTO dto, Model model, HttpSession httpSession) throws Exception {
//		logger.info("login");
		HashMap<String, Object> map = service.LoginCheck(dto);
		String path = "/main";
		if(map.get("result").equals(0)) {
			httpSession.setAttribute("logindto", dto);
			httpSession.setMaxInactiveInterval(60*5*5);
			model.addAttribute("pdto",pdto);
			path = "/main";
		}		
		System.out.println(map.get("msg"));
		model.addAttribute("msg",map.get("msg"));
		return path;
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join_get() {
		return "login/join";
//		logger.info("join_get");
	}
	
	//multipart로 보낼때는 MultipartFile로 받아야 한다
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join_post(loginDTO dto, Model model, MultipartFile file) throws Exception {
//		logger.info("join_post");
		String msg = service.join(dto,file);
		model.addAttribute("msg",msg);
		return "login/home";
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session,RedirectAttributes rttr) {
		session.invalidate();
		String msg = "로그아웃 되었습니다";
		rttr.addFlashAttribute("msg", msg);
		return "redirect:/";
		
	}
	@RequestMapping("/home")
	public String home() {
		return "/login/home";
	}

	
}
