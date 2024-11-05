package board.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import board.bean.BoardDTO;

@CrossOrigin
@RestController
public class Board2Controller {

	private List<BoardDTO> list = new ArrayList<BoardDTO>();
	
	public Board2Controller() {
		System.out.println("Board2Controller");
	}
	
	// 입력시 seq는 useRef()로 처리
	// name, subject, content는 입력. logtime은 new Date()
	@PostMapping(value = "board2/boardInput")
	public void boardInput(@RequestBody BoardDTO boardDTO) {
		System.out.println(boardDTO);
//		BoardDTO boardDTO = new BoardDTO();
//		boardDTO.setSeq(seq);
//		boardDTO.setName(name);
//		boardDTO.setSubject(subject);
//		boardDTO.setContent(content);
		boardDTO.setLogtime(new Date());
		
		list.add(boardDTO);
		System.out.println(list);
		
	}
	
	
	@RequestMapping(value = "board2/boardList")
	public List<BoardDTO> boardList() {
		return list;
	}
}
