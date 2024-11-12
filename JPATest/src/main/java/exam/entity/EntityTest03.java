package exam.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
public class EntityTest03 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 10)
	private String name;
	
	@Column(columnDefinition = "varchar(15) default '파랑'")
	private String favoriteColor;
	
	@Column(name="age", nullable = false)		// name="age" : DB에는 age로 들어간다.
	private int num1;
	
	@Column(name="score", precision = 6, scale = 2)	// 6자리,  소수점2자리 -> 1234.56
	private BigDecimal num2;
	
	@Lob
	private byte[] content1;
	@Lob
	private byte[] content2;
	@Lob
	private byte[] content3;
	
}



/*
 * @Lob : varchar 보다 크게 잡을 때 사용 
 * 
 * CLOB (Character Large Object): 일반적으로 긴 텍스트 데이터를 저장할 때 사용됩니다. 예를 들어, 긴 문자열 또는 큰 텍스트 파일 등을 저장할 때 사용됩니다.
 * 
 * BLOB (Binary Large Object): 바이너리 데이터를 저장할 때 사용됩니다. 예를 들어, 이미지, 비디오, 오디오 파일 등이 해당됩니다.
 * */
