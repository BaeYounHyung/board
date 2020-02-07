package org.spring.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.spring.dto.loginDTO;
import org.springframework.stereotype.Repository;
@Repository
public class loginDAOImpl implements loginDAO {
	@Inject
	private SqlSession session;
	
	@Override
	public List<loginDTO> select() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public loginDTO selectOne(loginDTO dto) throws Exception {
		return session.selectOne("Mapper.selectOne", dto);
	}

	@Override
	public int insert(loginDTO dto) throws Exception {
		return session.insert("Mapper.insert", dto);
	}

	@Override
	public int update(loginDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(loginDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public loginDTO selectOne(String id) throws Exception {	
		return session.selectOne("Mapper.selectOne_id", id);
	}


	

}
