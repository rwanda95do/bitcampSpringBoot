package board.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import board.bean.BoardDTO;

@RestController
public class BoardController {
	
	public BoardController() {
		System.out.println("BoardController 생성자");
	}
	
	@GetMapping(value = "board/hello")
	public String hello(@RequestParam(value = "name")String name) {
		return "Hello!!!!!!!!!" + name + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!";
	}
	
	@GetMapping(value = "board/getBoard")
	public BoardDTO getBoard() {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setSeq(10);
		boardDTO.setName("허균");
		boardDTO.setSubject("홍길동전");
		boardDTO.setContent("의로운 의적!");
		boardDTO.setLogtime(new Date());
		
		//System.out.println(boardDTO.toString());
		return boardDTO;
	}
	
	
	@GetMapping(value="board/getBoardList")
	public List<BoardDTO> getBoardList() {
		List<BoardDTO> list = new ArrayList<>();
	
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setSeq(10);
		boardDTO.setName("허균");
		boardDTO.setSubject("홍길동전");
		boardDTO.setContent("의로운 의적 !! ");
		boardDTO.setLogtime(new Date());
		list.add(boardDTO);
	
		boardDTO = new BoardDTO();
		boardDTO.setSeq(11);
		boardDTO.setName("김수정");
		boardDTO.setSubject("아기공룡 둘리");
		boardDTO.setContent("빙하타고 내려와 고길동집에서 구박 중");
		boardDTO.setLogtime(new Date());
		list.add(boardDTO);
	
		return list;
	}
}

/*
생성자에 있는 내용이 출력되지 않은 것은, Bean으로 생성되지 않았다는 것이다.

자동으로 생성되는 com.example.demo의 하위으로 만들어진 패키지(클래스)는 자동으로 설정이 되지만 
나머지는 안되기 때문에 직접 설정해줘야한다. 
*/

/*
@RestController는 JSP 같은 뷰를 별도로 만들지 않는 대신에 컨트롤러 메소드가 리턴하는 데이터 자체를 클라이언트로 보낸다.
클라이언트에 전달되는 데이터는 문자열, DTO, 컬렉션 형태의 자바 객체인데, 
자바 객체가 전달되는 경우에는 자동으로 JSON으로 변환하여 처리하게 된다.
 */