package org.spring.service;
import java.io.File;
import java.util.HashMap;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.controller.loginController;
import org.spring.dao.loginDAO;
import org.spring.dto.loginDTO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class loginServiceImpl implements loginService {
	@Inject
	private loginDAO dao;
	@Inject
	private BCryptPasswordEncoder encoder;
	private static final Logger logger = LoggerFactory.getLogger(loginServiceImpl.class);
	@Override
	public HashMap<String, Object> LoginCheck(loginDTO dto) throws Exception {
		HashMap<String, Object>map = new HashMap<>();
		String msg=null;
		int result=-1;
		loginDTO dto2 = dao.selectOne(dto);
		if(dto2 ==null || !dto2.getId().equals(dto.getId())) {
			msg = "아이디가 존재하지 않습니다";
			result = 2;
		}else {
			boolean passwordResult = encoder.matches(dto.getPassword(), dto2.getPassword()); //비밀번호 매칭
			if(!passwordResult) {
				msg = "비밀번호가 일치하지 않습니다";	
				result = 1;
			}else {
				msg = "로그인";
				result = 0;
			}
		}
		map.put("msg", msg);
		map.put("result", result);
		return map;
	}
	@Override
	public String join(loginDTO dto, MultipartFile file) throws Exception {
		//파일처리
		logger.info(file.getContentType());
		logger.info(file.getOriginalFilename());
		String filename = Long.valueOf(System.currentTimeMillis())+file.getOriginalFilename(); //파일이름이 겹치지 않게 생성
		String uploadPath = "D:/student/byh/spring/upload"; //업로드할 폴더
		File savafile = new File(uploadPath, filename);
		file.transferTo(savafile); //파일을 저장
		dto.setPhoto(filename);
		
		//암호화
		dto.setPassword(encoder.encode(dto.getPassword()));
		
		int result = dao.insert(dto);
		String msg = null;
		if(result == 1) msg = "회원가입 성공";
		else msg = "회원가입 실패";
		return msg;
	}
	@Override
	public loginDTO information(String id) throws Exception {
		loginDTO dto = dao.selectOne(id);
		return dto;
	}

}
