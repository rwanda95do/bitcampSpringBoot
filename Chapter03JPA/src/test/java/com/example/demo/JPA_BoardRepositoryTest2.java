package com.example.demo;

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
		boardEntity.setId("banana");
		boardEntity.setName("바나나");
		boardEntity.setSubject("노란바나나");
		boardEntity.setContent("바나나나나나나나나나나나나나");
		
		boardDAO.save(boardEntity);
	}
	
	@Test
	@Order(2) // 실행순서를 정한다. 숫자가 작을수록 먼저 실행된다.
	public void list() {
		List<BoardEntity> list = boardDAO.findAll();
		list.stream().forEach(System.out :: println);
	}
}
