package org.spring.service;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.spring.dao.BoardDAO;
import org.spring.dao.FileDAO;
import org.spring.dao.ReplyDAO;
import org.spring.dto.BoardDTO;
import org.spring.dto.FileDTO;
import org.spring.dto.PageDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
public class BoardServiceImpl implements BoardService{
	//inject : 자동주입시 형을먼저 체크하고 이름을 체크
	@Inject
	private BoardDAO dao;
	@Inject 
	private FileDAO fdao;
	//Resource : 파일업로드경로 주입
	@Resource(name="fileUploadPath")
	private String uploadPath;
	@Override
	public List<BoardDTO> selectList(PageDTO dto) throws Exception {
		// TODO Auto-generated method stub
		int curPage = dto.getCurPage();//현재페이지
		int perPage = dto.getPerPage();//한페이지의 게시물수
		int startNo = (curPage-1) * perPage + 1;//시작번호  .. mapper에서 사용
		int endNo = startNo + (perPage -1);//끝번호
		
		//시작페이지=현재페이지-((현재페이지-1)%페이지블럭의수)
		//끝페이지=시작페이지+(페이지블럭의수-1)
		//전체페이지수=전체게시물수/한페이지의게시물수 ..나머지가있으면 +1					
		int startPage = dto.getCurPage() - ((dto.getCurPage()-1) % dto.getPerBlock());
		int endPage = startPage + dto.getPerBlock()-1;
		int count = dao.nav(dto);
		int totPage = count/dto.getPerPage();
		if(count % dto.getPerPage() != 0) totPage++;
			
		//endPage가 totPage보다 크다면 endPage를 totPage로 바꿔준다
		if(totPage<endPage) endPage = totPage;
		dto.setStartPage(startPage);
		dto.setEndPage(endPage);
		dto.setTotPage(totPage);
		dto.setStartNo(startNo);
		dto.setEndNo(endNo);

		return dao.selectList(dto);
	}
	
	@Override
	public BoardDTO selectOnt(int num) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectOnt(num);
	}

	@Override
	public void insert(BoardDTO dto, MultipartHttpServletRequest file) throws Exception {
		int num = dao.insert(dto);
		List<MultipartFile> flist =  file.getFiles("file");
		System.out.println(flist.size());
		FileDTO fdto = new FileDTO();
		fdto.setNum(num);
		for(MultipartFile f : flist) {
			if(!f.isEmpty()) {
				String filename = Long.valueOf(System.currentTimeMillis())+f.getOriginalFilename();
				File savefile = new File(uploadPath, filename);
				f.transferTo(savefile);
				fdto.setFilename(filename);
				fdao.insert(fdto);					
			}
		}
	}

	@Override
	public void update(BoardDTO dto,MultipartHttpServletRequest file,int[] fnum) throws Exception {
		// TODO Auto-generated method stub
		dao.update(dto);
		List<MultipartFile> flist =  file.getFiles("file");
		if (!flist.get(0).getOriginalFilename().equals("")){
			for(int i = 0 ; i < flist.size(); i++) {
				String filename = 
						Long.valueOf(System.currentTimeMillis()) + flist.get(i).getOriginalFilename();
				File saveFile = new File(uploadPath, filename);
				//파일폴더에 저장
				flist.get(i).transferTo(saveFile);
				
				//dto에 세팅 
				FileDTO fdto = new FileDTO();

				fdto.setFilename(filename);
				if (i<fnum.length) {
					fdto.setFnum(fnum[i]);
					fdao.update(fdto);
				}else {   //기존파일보다 더 많다면 추가
					fdto.setNum(dto.getNum()); //게시물의 번호
					fdao.insert(fdto);
				}
				
			}
			
			//기존파일의 수가 더 많다면 삭제
			if (flist.size() < fnum.length) {
				for(int i = flist.size() ; i < fnum.length; i++) {
					//dto에 세팅 
					fdao.deleteOne(fnum[i]);
				}
			}
		}
		
	}

	@Override
	public void delete(int num) throws Exception {
		// TODO Auto-generated method stub
		dao.delete(num);
	}

	@Override
	public void read(int num) throws Exception {
		// TODO Auto-generated method stub
		dao.read(num);
		
	}



}
