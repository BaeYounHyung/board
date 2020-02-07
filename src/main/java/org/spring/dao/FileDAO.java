package org.spring.dao;

import java.util.List;

import org.spring.dto.FileDTO;

public interface FileDAO {
	public void insert(FileDTO dto)throws Exception;
	public void delete(int num)throws Exception;
	public void deleteOne(int rnum)throws Exception;
	public void update(FileDTO dto)throws Exception;
	public List<FileDTO> selectOne(int num)throws Exception;
}
