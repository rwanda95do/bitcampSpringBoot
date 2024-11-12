package exam.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class EntityTest05 {

	@Id
	private int id;
	private String username;
	
	
	// 연관관계매핑 
	// Team의 PK와 EntityTest05의 FK
	@ManyToOne
	private Team t;	// DB의 필드명은 t_TEAM_ID  
					//-> 이게 싫으면 @JoinColumn으로 필드명을 지정
	
	
	public EntityTest05() {}
	public EntityTest05(String username, Team team) {
		this.username = username;
		t=team;
	}
}
