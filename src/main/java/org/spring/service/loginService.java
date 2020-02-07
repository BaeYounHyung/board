package org.spring.service;

import java.util.HashMap;

import org.spring.dto.loginDTO;
import org.springframework.web.multipart.MultipartFile;

public interface loginService {
	public HashMap<String, Object> LoginCheck(loginDTO dto)throws Exception;
	public String join(loginDTO dto, MultipartFile file)throws Exception;
	public loginDTO information(String id) throws Exception;
}
