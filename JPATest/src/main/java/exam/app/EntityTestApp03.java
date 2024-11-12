package exam.app;

import java.util.ArrayList;
import java.util.List;

import exam.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class EntityTestApp03 {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		Person person1 = new Person();
		person1.setName("홍길동");
		person1.setAge(25);
		
		Person person2 = new Person();
		person2.setName("이제훈");
		person2.setAge(20);
		
		Person person3 = new Person();
		person3.setName("김태리");
		person3.setAge(40);

		manager.persist(person1);
		manager.persist(person2);
		manager.persist(person3);
		

		
		TypedQuery<Person> query = manager.createQuery("SELECT p FROM Person p", Person.class);
		List<Person> list = query.getResultList();
		list.stream().forEach(System.out::println);
		
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		
	}

}
