package org.spring.service;

import java.util.List;

import org.spring.dto.BoardDTO;
import org.spring.dto.PageDTO;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface BoardService {
	public List<BoardDTO> selectList(PageDTO dto) throws Exception;
	public BoardDTO selectOnt(int num) throws Exception;
	public void insert(BoardDTO dto, MultipartHttpServletRequest file) throws Exception;
	public void update(BoardDTO dto,MultipartHttpServletRequest file,int[] fnum) throws Exception;
	public void read(int num) throws Exception;
	public void delete(int num) throws Exception;

}
