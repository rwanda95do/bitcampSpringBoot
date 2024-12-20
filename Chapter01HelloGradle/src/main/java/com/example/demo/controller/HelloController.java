package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController		// 하나하나 @ResponsBody를 해줄 필요가 없음
public class HelloController {

	public HelloController() {
		System.out.println("HelloController 생성자");
	}
	
	@RequestMapping(value = "/")	// spring web을 설치했기 때문에 가능
	//@ResponseBody 		// 브라우저에 바로 문자열 뿌리기
	public String index() {
		return "Hello Spring Boot!!!!!";	
	}
	
	@RequestMapping(value = "/hello")
	public String hello(@RequestParam(value = "name") String name) {
		return "안녕ㅎㅏ세요  " + name + "님. ";
	}
}


// @RestController는 JSP 같은 뷰를 별도로 만들지 않는 대신에 컨트롤러 메소드가 리턴하는 데이터 자체를 클라이언트로 보낸다.