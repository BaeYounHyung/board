package org.spring.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.spring.dto.BoardDTO;
import org.spring.dto.PageDTO;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO{
@Inject
private SqlSession session;
	@Override
	public List<BoardDTO> selectList(PageDTO dto)throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("BoardMapper.selectList", dto);
	}

	@Override
	public BoardDTO selectOnt(int num) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne("BoardMapper.selectOne",num);
	}
	@Override
	public int insert(BoardDTO dto) throws Exception{
		int num = session.insert("BoardMapper.insert",dto);
		return dto.getNum();
	}

	@Override
	public void update(BoardDTO dto) throws Exception{
		// TODO Auto-generated method stub
		System.out.println(dto);
		session.update("BoardMapper.update",dto);
		
	}

	@Override
	public void delete(int num) throws Exception{
		// TODO Auto-generated method stub
		session.delete("BoardMapper.delete",num);
		
	}

	@Override
	public void read(int num) throws Exception {
		// TODO Auto-generated method stub
		session.update("BoardMapper.read",num);
		
	}

	@Override
	public int nav(PageDTO pdto) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne("BoardMapper.nav",pdto);
	}

	@Override
	public void replyCountUp(int num) throws Exception {
		// TODO Auto-generated method stub
		session.selectOne("BoardMapper.replyCountUp",num);
	}

	@Override
	public void replyCountDown(int num) throws Exception {
		// TODO Auto-generated method stub
		session.selectOne("BoardMapper.replyCountDown",num);
	}





}
