package exam.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Team {

	@Id
	@Column(name="TEAM_ID")
	private String id;
	private String name;
}
