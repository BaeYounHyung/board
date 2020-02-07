package org.spring.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.spring.dao.FileDAO;
import org.spring.dto.FileDTO;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

@Service
public class FileServiceImpl implements FileService{
	@Inject
	private FileDAO dao;
	@Resource(name="fileUploadPath")
	private String uploadPath;
	
	@Override
	public List<FileDTO> selectOne(int num) throws Exception {
		return dao.selectOne(num);
	}
	
	@Override
	public void Download(String filename, HttpServletResponse response) throws Exception {
		String fileurl = uploadPath + "/" + filename;
		//파일 읽기 스트림생성
		FileInputStream fis = new FileInputStream(fileurl);
		//한글파일이름 인코딩
		filename = new String(filename.getBytes("utf-8"), "iso-8859-1");
		//헤더의 설정 변경
		//	ㄴ(첨부파일이라는 종류, 파일이름을 알려줌)
		response.setHeader("Content-Disposition", "attachment;filename="+filename);
		//파일 내보내기 스트림 생성
		OutputStream out = response.getOutputStream();
		FileCopyUtils.copy(fis, out);
	}

	@Override
	public void delete(int num) throws Exception {
		// TODO Auto-generated method stub
		dao.delete(num);
	}

}
