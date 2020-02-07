package org.spring.dao;

import java.util.List;

import org.spring.dto.ReplyDTO;

public interface ReplyDAO {
	public List<ReplyDTO> select(int num) throws Exception;
	public ReplyDTO selectOne(int rnum) throws Exception;
	public void insert(ReplyDTO dto) throws Exception;
	public void update(ReplyDTO dto) throws Exception;
	public void delete(int num) throws Exception;
	public void deleteOne(int rnum) throws Exception;
}
