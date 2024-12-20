package com.example.demo;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardDAO extends JpaRepository<BoardEntity, Integer> {

	public BoardEntity findBySeq(int seq);


	public List<BoardEntity> findByLogtimeNull();


	public List<BoardEntity> findByIdContaining(String string);

	public List<BoardEntity> findByLogtimeAfter(LocalDateTime atStartOfDay);


	public List<BoardEntity> findBySeqBetween(int i, int j);


	public List<BoardEntity> findAllByOrderBySeqDesc();


}
