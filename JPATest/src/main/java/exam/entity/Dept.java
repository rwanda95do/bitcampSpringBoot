package exam.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Dept {

	@Id
	private int deptno;
	
	@Column(length = 20)
	private String dname;
	
	@ManyToOne
	@JoinColumn(name="loc_code", referencedColumnName = "LOC_CODE")
	private Locations loc_code;
}


