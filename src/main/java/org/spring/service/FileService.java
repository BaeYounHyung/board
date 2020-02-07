package org.spring.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.spring.dto.FileDTO;

public interface FileService {
	public List<FileDTO> selectOne(int num) throws Exception;
	public void Download(String filename, HttpServletResponse response)throws Exception;
	public void delete(int num)throws Exception;
}
