package org.spring.service;

import java.util.List;

import javax.inject.Inject;

import org.spring.dao.BoardDAO;
import org.spring.dao.ReplyDAO;
import org.spring.dto.ReplyDTO;
import org.springframework.stereotype.Service;
@Service
public class ReplyServiceImpl implements ReplyService {
	@Inject
	private ReplyDAO dao;
	@Inject
	private BoardDAO bdao;
	
	@Override
	public List<ReplyDTO> select(int num) throws Exception {
		// TODO Auto-generated method stub
		return dao.select(num);
	}

	@Override
	public void insert(ReplyDTO dto) throws Exception {
		// TODO Auto-generated method stub
		dao.insert(dto);
		bdao.replyCountUp(dto.getNum());
	}

	@Override
	public void update(ReplyDTO dto) throws Exception {
		// TODO Auto-generated method stub
		dao.update(dto);
	}

	@Override
	public void delete(int num) throws Exception {
		// TODO Auto-generated method stub
		dao.delete(num);
	}

	@Override
	public void deleteOne(ReplyDTO dto) throws Exception {
		// TODO Auto-generated method stub
		dao.deleteOne(dto.getRnum());
		bdao.replyCountDown(dto.getNum());
	}

	@Override
	public ReplyDTO selectOne(int rnum) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectOne(rnum);
	}

}
