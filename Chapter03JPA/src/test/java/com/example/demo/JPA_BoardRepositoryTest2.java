package com.example.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import jakarta.transaction.Transactional;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JPA_BoardRepositoryTest2 {

	@Autowired
	private BoardDAO boardDAO;
	
	@BeforeEach
	public void solid() {
		System.out.println("-".repeat(80));
	}
	
	@AfterEach
	public void solid2() {
		System.out.println("=".repeat(80));
	}
	
	@Test
	@Order(1) // 실행순서를 정한다. 숫자가 작을수록 먼저 실행된다.
	@Rollback(false)	// 기본은 true, DML(insert)문을 수행한 후에는 rollback를 하고 싶지 않으면 false로 설정해야한다. 
	public void insert() {
		BoardEntity boardEntity = new BoardEntity();
		boardEntity.setId("pepepro");
		boardEntity.setName("빼빼로");
		boardEntity.setSubject("누드빼빼로");
		boardEntity.setContent("빼빼로의 누드 빼빼로 롯데 뻬빼로");
		
		boardDAO.save(boardEntity);
	}
	
	@Test
	@Order(2) // 실행순서를 정한다. 숫자가 작을수록 먼저 실행된다.
	public void list() {
		List<BoardEntity> list = boardDAO.findAll();
		list.stream().forEach(System.out :: println);
	}

// ----------------------------------------------------
	// 쿼리 메서드 
	@Test
	@Order(4) 
	public void byId() {
		BoardEntity boardEntity = boardDAO.findById(6).get();	// findById() : @id된 값으로 찾는다
		System.out.println(boardEntity);
	}
	
	@Test
	@Order(3) 
	public void bySeq() {
		BoardEntity boardEntity = boardDAO.findBySeq(6);	// The method findBySeq(int) is undefined for the type BoardDAO -> BoardDAO에 만든다 
		System.out.println(boardEntity);
	}

	// seq의 값이 2보다크고 5보다 작은 값 
	@Test
	public void findBySeqBetween() {
		List<BoardEntity> list = boardDAO.findBySeqBetween(3,6);	 
		list.stream().forEach(System.out::println);
	}
	
	
	@Test
	@Order(5) 
	public void byLogtimeNull() {
		List<BoardEntity> list = boardDAO.findByLogtimeNull();	
		list.stream().forEach(System.out::println);
	}
	
	@Test
	@Order(5) 
	public void findByIdContaining() {
		List<BoardEntity> list = boardDAO.findByIdContaining("o");	
		list.stream().forEach(System.out::println);
	}
	
	@Test
	public void findByLogtimeAfter() {
	// BoardEntity :: private java.sql.Date logtime;	
		// List<BoardEntity> list = boardDAO.findByLogtimeAfter(java.sql.Date.valueOf("2024.11.12"));	
		
		
	//  BoardEntity :: private LocalDateTime logtime = LocalDateTime.now();	
		List<BoardEntity> list = boardDAO.findByLogtimeAfter(LocalDate.parse("2024-11-12").atStartOfDay());
		list.stream().forEach(System.out::println);
		
		List<BoardEntity> list2 = boardDAO.findByLogtimeAfter(LocalDateTime.of(24, 11, 12, 00, 00));
		list2.forEach(System.out::println);
	}
}
