package org.spring.dao;

import java.util.List;

import org.spring.dto.BoardDTO;
import org.spring.dto.PageDTO;

public interface BoardDAO {
	public List<BoardDTO> selectList(PageDTO dto) throws Exception;
	public BoardDTO selectOnt(int num) throws Exception;
	public int insert(BoardDTO dto) throws Exception;
	public void update(BoardDTO dto) throws Exception;
	public void read(int num) throws Exception;
	public void delete(int num) throws Exception;
	public int nav(PageDTO pdto) throws Exception;
	public void replyCountUp(int num) throws Exception;
	public void replyCountDown(int num) throws Exception;
}
