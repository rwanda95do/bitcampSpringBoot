package exam.entity;

import org.hibernate.boot.model.internal.DelayedParameterizedTypeBean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Emp {

	@Id
	private int empno;
	
	@Column(length = 14)
	private String ename;
	
	@Column(length = 30)
	private String job;
	
	private Integer mgr;
	private java.sql.Date hiredate;
	private int sal;
	private Integer comm;
	
	
	
	// 연관매핑
	//@ManyToOne(fetch = FetchType.EAGER)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "deptno")
	private Dept deptno;
	

}



/*
 * 
 * 즉시 로딩 (Eager Loading)
연관된 엔티티를 즉시 로딩된다.
부모 엔티티가 로딩될 때 연관된 모든 데이터도 함께 로딩된다.
부모 엔티티를 로드할 때 연관된 데이터도 함께 DB에서 조회되어, 한 번의 쿼리로 모든 데이터를 가져온다.

 * 지연 로딩 (Lazy Loading)
연관된 엔티티를 실제로 사용할 때까지 데이터를 로딩하지 않는다.
연관된 데이터는 해당 필드나 연관된 엔티티에 접근할 때, 즉 실제로 해당 데이터를 참조하거나 사용하려고 할 때 DB에서 로딩된다.

 */

