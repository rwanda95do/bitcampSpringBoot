package member.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import member.bean.MemberDTO;
import member.bean.MemberPaging;
import member.dao.MemberRepository;
import member.entity.MemberEntity;
import member.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private MemberPaging memberPaging;
	
// 아이디 중복체크	
	@Override
	public String isExistId(String id) {
		MemberEntity memberEntity = memberRepository.findById(id);
		System.out.println("isExistId : "+ memberEntity);
		
		if(memberEntity == null) {
			return "non_exist";			
		} else {
			return "exist";
		}
		
		
	}

	
// 회원가입
	@Override
	public void write(MemberEntity memberEntity) {
		System.out.println("write : "+ memberEntity);
		
		memberRepository.save(memberEntity);
		
	}


// 회원가입 완료후 회원목록
	@Override
	public Map<String, Object> getMemberlist(Pageable pageable) {
		
		Page<MemberEntity> list = memberRepository.findAll(pageable);
		
	// 총글수 
		// int totalA = (int) memberRepository.count();
		int totalA = memberRepository.findAll().size();
		System.out.println(totalA);
		
		memberPaging.setCurrentPage(pageable.getPageNumber()+1);		// page=0이면, 1페이지
		memberPaging.setPageBlock(3);
		memberPaging.setPageSize(3);
		memberPaging.setTotalA(totalA);
		memberPaging.makePagingHTML();
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("memberPaging", memberPaging);
		
		return map;
	}


	@Override
	public List<MemberEntity> getSearchList(String columnName, String value) {

	/*	
	 * 쿼리 메서드
	 * 
		// oracle : select * from membertbl where [name/id] list '%홍%'
		// mysql : select * from membertbl where [name/id] list concat('%','홍','%')
		
		if(columnName.equals("name")) {
			// 쿼리메서드 : 이름으로 검색
			return memberRepository.findByNameContaining(value);
		} else { // columnName.equals("id")
			return memberRepository.findByIdContaining(value);
		}
	*/
	
	// @Query 어노테이션
		if(columnName.equals("name")) {
			// getSearchName는 일반 메서드임
			return memberRepository.getSearchName(value);
		}else { // (columnName.equals("id")) 
			return memberRepository.getSearchId(value);
		} 
		
	}


	


}

/*
Optional
스프링 데이터 JPA를 사용하며 CrudRepository의 findById 메서드 리턴 타입인 Optional 클래스에 처음 접하게 되었다.
Optional은 Java 8에 추가된 새로운 API로 이전에 하던 '고통스러운 null 처리'를 '잘' 다룰 수 있게 도와주는 클래스라고 한다. 

Optional 클래스란?
Optional이란 'null일 수도 있는 객체'를 감싸는 일종의 Wrapper 클래스이다.

쿼리 메소드
JPA에서 제공하는 CrudRepository, 또는 JpaRepository를 이용해서 기본적인 CRUD 기능을 수행했다.
일반적으로 JPA를 이용해서 목록 기능을 구현할 때는 JPQL(Java Persistence Query Language)을 이용하면 된다.
JPQL은 검색 대상이 테이블이 아닌 엔티티 라는 것만 제외하고는 기본 구조와 문법이 기존의 SQL과 유사하다.

스프링 JPA에서는 복잡한 JPQL을 대신해서 처리할 수 있는 쿼리 메소드라는 기능을 제공한다.
쿼리 메소드는 메소드의 이름으로 필요한 쿼리를 만들어주는 기능이다.

쿼리 메소드를 작성할 때 엔티티 이름은 생략할 수 있다.
현재 사용하는 Repository 인터페이스에서 선언된 타입 정보를 기준으로 자동 엔티티 이름이 적용된다.

쿼리 메소드의 리턴 타입은 Page<T>, Slice<T>, List<T> 이며 모두 Collection<T> 타입이다.
이 중에서 가장 많이 사용하는 것은 Page<T>, List<T>로서, 단순히 목록을 검색하려면 List<T>를 사용하고 페이징 처리를 하려면 Page<T>를 사용하면 된다.

*** @Query 어노테이션
일반적인 쿼리는 지금까지 학습한 스프링 데이터 JPA의 쿼리 메소드만으로도 충분하다. 
하지만 복잡한 쿼리를 사용하거나 연관관계에 기반한 조인 검색을 처리하기 위해서는 JPQL(Java Persistence Query Language)을 사용해야 한다. 
또는 성능상 어쩔 수 없이 특정 데이터베이스에 종속적인 네이티브 쿼리를 사용해야하는 경우도 있다.

JPQL은 일반적인 SQL과 유사한 문법을 가지고 있지만 검색 대상이 테이블이 아니라 영속성 컨텍스트에 등록된 엔티티이다.
따라서 FROM 절에 엔티티 이름과 컬럼 대신 엔티티가 가지고 있는 변수를 조회하기 때문에
SELECT나 WHERE 절에서 사용하는 변수 이름은 대소문자를 구분하여 정확하게 지정해야 한다.
*/

