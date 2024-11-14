package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public void write() {
		BoardEntity boardEntity = new BoardEntity();
		boardEntity.setId("grape");
		boardEntity.setName("포도");
		boardEntity.setSubject("보라색거봉포도");
		boardEntity.setContent("포도송송송송송소옷옷옷이");
		
		//DB
		boardDAO.save(boardEntity);
	}

	@Override
	public List<BoardEntity> list() {
		// boardDAO.findAll() :: select * from boardtbl;

		//return boardDAO.findAll(Sort.by("seq").descending());
		
		// 쿼리메서드 사용
		return boardDAO.findAllByOrderBySeqDesc();
	}

}
