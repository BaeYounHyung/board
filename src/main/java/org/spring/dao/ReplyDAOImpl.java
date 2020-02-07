package org.spring.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.spring.dto.ReplyDTO;
import org.springframework.stereotype.Repository;
@Repository
public class ReplyDAOImpl implements ReplyDAO {
	@Inject
	private SqlSession session;
	
	@Override
	public List<ReplyDTO> select(int num) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("ReplyMapper.selectList",num);
	}
	@Override
	public void insert(ReplyDTO dto) throws Exception {
		// TODO Auto-generated method stub
		session.insert("ReplyMapper.insert",dto);
		
	}

	@Override
	public void update(ReplyDTO dto) throws Exception {
		// TODO Auto-generated method stub
		session.update("ReplyMapper.update",dto);
	}

	@Override
	public void delete(int num) throws Exception {
		// TODO Auto-generated method stub
		session.delete("ReplyMapper.delete",num);	
	}

	@Override
	public void deleteOne(int rnum) throws Exception {
		// TODO Auto-generated method stub
		session.delete("ReplyMapper.deleteOne",rnum);
	}
	@Override
	public ReplyDTO selectOne(int rnum) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne("ReplyMapper.selectOne",rnum);
	}


}
