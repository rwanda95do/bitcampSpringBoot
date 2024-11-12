package exam.app;

import java.time.LocalDateTime;
import java.util.Random;

import exam.entity.EntityTest01;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Persistence;

public class EntityTestApp01 {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
		EntityManager manager = factory.createEntityManager();
		EntityTest01 entityTest01;
		
		manager.getTransaction().begin(); 	// 트랜잭션 시작
		
/*
// @GeneratedValue(strategy = GenerationType.IDENTITY) 설정하기 전 		

		entityTest01 = new EntityTest01();
		entityTest01.setId(10);
		entityTest01.setName("홍길동");
		entityTest01.setAge(25);
		entityTest01.setBirthdaty(LocalDateTime.now());
		
		manager.persist(entityTest01);
*/		
		
		
// @GeneratedValue(strategy = GenerationType.IDENTITY) 설정 후 
		for(int i=1; i<=5; i++) {
			entityTest01 = new EntityTest01();
			entityTest01.setName("홍길동 " + i);
			entityTest01.setAge((int)(Math.random()*26) + 25);
			entityTest01.setBirthdaty(LocalDateTime.now());
			
			manager.persist(entityTest01);		// 임시 저장소			
		}
		
		
	
		manager.getTransaction().commit();		// 커밋 : DB에 저장되는 시점(갱신)
		
		manager.close();
		factory.close();
		
	}
}
