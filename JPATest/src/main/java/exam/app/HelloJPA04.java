package exam.app;

import java.util.List;

import exam.entity.Emp;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class HelloJPA04 {

	public static void main(String[] args) {


		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
		EntityManager manager = factory.createEntityManager();
		
		String fetchJoinJpql = "select distinct t " + 
							   "from Emp t left join fetch t.deptno " + 
							   "left join fetch t.deptno.loc_code";
		

		Query query = manager.createQuery(fetchJoinJpql, Emp.class);	
		
		List<Emp> list = query.getResultList();
		
		for(Emp emp : list) {
			System.out.println(emp);
		}	// for
		
		
		System.out.println("list 총 개수 : " + list.size());
		
		manager.close();
		factory.close();
	}

}


/*
 * Fetch Join 
 연관된 엔티티들을 한 번의 쿼리로 모두 가져온다
 여러 개의 연관된 엔티티들을 조인하여 한 번의 뭐리로 모든 데이터들을 가져온다.  
 * */
