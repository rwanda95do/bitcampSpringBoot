package exam.app;

import java.util.List;

import exam.entity.Emp;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class HelloJPA03 {

	public static void main(String[] args) throws InterruptedException {
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
		EntityManager manager = factory.createEntityManager();
		
		Query query = manager.createQuery("SELECT emp FROM Emp emp", Emp.class);	
		
		List<Emp> list = query.getResultList();
		
		for(Emp emp : list) {
			System.out.println("직원이름 : " + emp.getEname());
			//Thread.sleep(1000);
			
			if(emp.getDeptno() != null) {
				System.out.println("부서 :" + emp.getDeptno().getDname()+ "\n");
			} else {
				System.out.println("부서 : 없음\n");
			}
			
			
		}	// for
		
		System.out.println("list 총 개수 : " + list.size());
		
		manager.close();
		factory.close();
	}

}
