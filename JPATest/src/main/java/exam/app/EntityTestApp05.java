package exam.app;

import java.util.List;

import exam.entity.EntityTest01;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class EntityTestApp05 {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		System.out.println("엔티티 삭제!!!");
		EntityTest01 entityTest01 = manager.find(EntityTest01.class, 10);
		manager.remove(entityTest01);
		
		TypedQuery<EntityTest01> tq = manager.createQuery("select t from EntityTest01 t", EntityTest01.class);
		List<EntityTest01> list = tq.getResultList();
		list.stream().forEach(System.out::println);
		
		manager.getTransaction().commit();

		manager.close();
		factory.close();
	}

}
