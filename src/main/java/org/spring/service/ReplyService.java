package org.spring.service;

import java.util.List;

import org.spring.dto.ReplyDTO;

public interface ReplyService {
	public List<ReplyDTO> select(int num) throws Exception;
	public ReplyDTO selectOne(int rnum) throws Exception;
	public void insert(ReplyDTO dto) throws Exception;
	public void update(ReplyDTO dto) throws Exception;
	public void delete(int num) throws Exception;
	public void deleteOne(ReplyDTO dto) throws Exception;
}
