package exam.app;

import java.time.LocalDateTime;
import java.util.List;

import exam.entity.EntityTest01;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class EntityTestApp04 {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		EntityTest01 entityTest01;
		
		for(int i=1; i<=5; i++) {
			entityTest01 = new EntityTest01();
			entityTest01.setName("또치 " + i);
			entityTest01.setAge((int)(Math.random()*26) + 25);
			entityTest01.setBirthdaty(LocalDateTime.now());
			
			manager.persist(entityTest01);		// 임시 저장소			
		} // for

		TypedQuery<EntityTest01> tq = manager.createQuery("select t from EntityTest01 t", EntityTest01.class);
		List<EntityTest01> list = tq.getResultList();
		list.stream().forEach(System.out::println);
		
		//manager.getTransaction().commit();
		manager.flush();		// commit 메소드를 불러들인다
	
		System.out.println("----------------------------------------");
		tq = manager.createQuery("select t from EntityTest01 t", EntityTest01.class);
		list = tq.getResultList();
		list.stream().forEach(System.out::println);
		
		manager.getTransaction().rollback();
		
		// 디비에는 반영되지만, 데이터베이서에 저장되지 않아서 눈에 보이지 않기 때문에...허허.. 
		System.out.println("----------------------------------------");
		tq = manager.createQuery("select t from EntityTest01 t", EntityTest01.class);
		list = tq.getResultList();
		list.stream().forEach(System.out::println);
		
		manager.close();
		factory.close();
	
		
	}	// main()

}
