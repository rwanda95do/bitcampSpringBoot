package member.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import member.entity.MemberEntity;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Integer>{ //JpaRepository<엔티티, PK 타입>

// 쿼리메서드
	public MemberEntity findById(String id);

	public List<MemberEntity> findByNameContaining(String value);
	public List<MemberEntity> findByIdContaining(String value);

/*
// @Query 어노테이션 방법1 
	// @Query("select * from ENTITY클래스명 ENTITY객체명 where ENTITY객체명.변수 like concat('%',?1,'%')")
	@Query("select entity from MemberEntity entity where entity.name like concat('%',?1,'%')")
	public List<MemberEntity> getSearchName(String value);
	@Query("select entity from MemberEntity entity where entity.id like concat('%', ?1, '%')")
	public List<MemberEntity> getSearchId(String value);	
*/
	
// @Query 어노테이션 방법2 : ?를 사용하면 무슨 값이 올지 모르니 @Param으로 값을 알려준다
	// @Query("select * from ENTITY클래스명 ENTITY객체명 where ENTITY객체명.변수 like concat('%',?1,'%')")
	@Query("select entity from MemberEntity entity where entity.name like concat('%',:value,'%')")
	public List<MemberEntity> getSearchName(@Param("") String value);
	@Query("select entity from MemberEntity entity where entity.id like concat('%', ?1, '%')")
	public List<MemberEntity> getSearchId(String value);	
	
}
