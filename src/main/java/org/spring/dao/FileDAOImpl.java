package org.spring.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.spring.dto.FileDTO;
import org.springframework.stereotype.Repository;

@Repository
public class FileDAOImpl implements FileDAO {
	@Inject
	private SqlSession session;
	
	@Override
	public void insert(FileDTO dto) {
		// TODO Auto-generated method stub
		session.insert("FileMapper.insert",dto);
	}

	@Override
	public List<FileDTO> selectOne(int num) {
		// TODO Auto-generated method stub
		return session.selectList("FileMapper.selectOne",num);
	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		session.delete("FileMapper.delete", num);
	}

	@Override
	public void update(FileDTO dto) throws Exception {
		// TODO Auto-generated method stub
		session.update("FileMapper.update", dto);
	}

	@Override
	public void deleteOne(int rnum) throws Exception {
		// TODO Auto-generated method stub
		session.delete("FileMapper.deleteOne", rnum);
	}

}
