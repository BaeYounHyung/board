package org.spring.dao;

import java.util.List;

import org.spring.dto.loginDTO;

public interface loginDAO {
	public List<loginDTO> select() throws Exception;
	public loginDTO selectOne(loginDTO dto) throws Exception;
	public loginDTO selectOne(String id) throws Exception;
	public int insert(loginDTO dto) throws Exception;
	public int update(loginDTO dto) throws Exception;
	public int delete(loginDTO dto) throws Exception;
}
