package org.spring.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.spring.dto.ReplyDTO;
import org.spring.dto.loginDTO;
import org.spring.service.ReplyService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController //컨트롤러를 Rest형태로
@RequestMapping("/reply") //reply로 들어오는 모든url
public class ReplyController {
	/*public @ResponseBody 메소드이름(){}*/
	
	@Inject
	private ReplyService rs;
	
	//댓글추가
	//@RequestBody json객체를 받아준다
	@RequestMapping(value="/", method=RequestMethod.POST, produces="application/text;charset=utf-8")
	public String insert(@RequestBody ReplyDTO dto,HttpSession httpSession) throws Exception {
		/*dto.setUserid("qweasd"); // 임시아이디*/
		loginDTO ldto = (loginDTO)httpSession.getAttribute("logindto");
		System.out.println(ldto.getId());
		dto.setUserid(ldto.getId());
		rs.insert(dto);
		return ""; //반환값으로 문자를 반환
	}
	
	//댓글리스트
	//@PathVariable("") url에서 넘어온 값을 받아준다
	@RequestMapping(value="/{num}", method=RequestMethod.GET)
	public List<ReplyDTO> list(@PathVariable("num") int num) throws Exception{
		return rs.select(num);
		
	}
	
	//댓글삭제
	@RequestMapping(value="/",method=RequestMethod.DELETE, produces="application/text;charset=utf-8")
	public String delete(@RequestBody ReplyDTO dto,HttpSession httpSession) throws Exception {
		dto = rs.selectOne(dto.getRnum());
		loginDTO ldto = (loginDTO)httpSession.getAttribute("logindto");
		System.out.println(ldto);
		if(dto.getUserid().equals(ldto.getId())) {
			rs.deleteOne(dto);
			return "삭제완료";
		}
		else {
			return "삭제불가능";
		}
	}
	//댓글변경
	@RequestMapping(value="/", method=RequestMethod.PUT, produces="application/text;charset=utf-8")
	public String update(@RequestBody ReplyDTO dto,HttpSession httpSession) throws Exception {
		dto = rs.selectOne(dto.getRnum());
		loginDTO ldto = (loginDTO)httpSession.getAttribute("logindto");
		System.out.println(ldto);
		if(dto.getUserid().equals(ldto.getId())) {
			rs.update(dto);
			return "수정완료"; //반환값으로 문자를 반환
		}
		else {
			return "수정불가능";
		}
	}
	
}
