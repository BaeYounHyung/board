package org.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.dao.BoardDAO;
import org.spring.dto.BoardDTO;
import org.spring.dto.FileDTO;
import org.spring.dto.PageDTO;
import org.spring.dto.loginDTO;
import org.spring.service.BoardService;
import org.spring.service.FileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/board/*")
@SessionAttributes("pdto")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	@Inject
	private BoardService bs;
	@Inject
	private FileService fs;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(PageDTO dto ,Model model) {
		/*session값을 세팅*/
		model.addAttribute("pdto",dto);
		return "board/list";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listGet(@ModelAttribute("pdto")PageDTO dto, Model model) throws Exception {
		List<BoardDTO> list = bs.selectList(dto);
//		dto = bs.nav(dto);
		model.addAttribute("pdto", dto);
		model.addAttribute("list", list);
		return "/board/list";
	
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String addGet() {
		return "board/add";

	}
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String addPost(BoardDTO dto, MultipartHttpServletRequest file, RedirectAttributes rttr) throws Exception {
		bs.insert(dto, file);
		rttr.addFlashAttribute("msg", "저장완료");
		return "redirect:/board/list";
	}
	@RequestMapping(value = "/selectOne")
	public String selectOne(int num, Model model) throws Exception {
		bs.read(num);
		BoardDTO dto = bs.selectOnt(num);
		List<FileDTO>list = fs.selectOne(num);
		model.addAttribute("dto", dto);
		model.addAttribute("list", list);
		return "board/content";
	}
	//다운로드
	@RequestMapping(value = "/download")
	public void download(@RequestParam("filename")String filename, HttpServletResponse response) throws Exception {
		System.out.println(filename+"다운다운");
		fs.Download(filename, response);	
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateGet(int num, HttpSession httpSession, Model model,RedirectAttributes rttr) throws Exception {
		loginDTO ldto = (loginDTO)httpSession.getAttribute("logindto");
		BoardDTO dto = bs.selectOnt(num);
		if(ldto.getId().equals(dto.getUserid())) {
			List<FileDTO>list = fs.selectOne(num);
			model.addAttribute("dto", dto);
			model.addAttribute("list", list);	
			return "board/update";
		}
		else {
			rttr.addFlashAttribute("msg","수정불가능");
			rttr.addAttribute("num",dto.getNum());
			return "redirect:/board/selectOne";
		}
		
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updatePost(BoardDTO dto,MultipartHttpServletRequest file, int[] fnum, RedirectAttributes rttr) throws Exception {
		bs.update(dto,file,fnum);
		rttr.addFlashAttribute("msg","수정완료");
		return "redirect:/board/list";
	}
	@RequestMapping(value = "/delete")
	public String delete(int num,HttpSession httpSession,RedirectAttributes rttr) throws Exception {
		loginDTO ldto = (loginDTO)httpSession.getAttribute("logindto");
		BoardDTO dto = bs.selectOnt(num);
		if(ldto.getId().equals(dto.getUserid())) {
			fs.delete(num);
			bs.delete(num);
			rttr.addFlashAttribute("msg","삭제완료");
			return "redirect:/board/list";			
		}
		else {
			rttr.addFlashAttribute("msg","삭제불가능");
			rttr.addAttribute("num",dto.getNum());
			return "redirect:/board/selectOne";
		}
		
	}
}
