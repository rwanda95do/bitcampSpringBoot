package exam.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class EntityTest04 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Temporal(TemporalType.TIME)		// DB타입이 time(6)
	private java.util.Date utilTime;
	
	@Temporal(TemporalType.DATE)		// DB타입이 date
	private java.util.Date utilDate;
	
	@Temporal(TemporalType.TIMESTAMP)		// DB타입이 datetime(6)
	private java.util.Date utilTimestamp;
	
	
	private java.util.Date utilPlainDate;		// DB타입이 datetime(6)
	private java.sql.Date sqlPlainDate;		// DB타입이 date
	
	@Column(columnDefinition = "TIME")
	private LocalTime localTime1;			// DB타입이 TIME
	
	private LocalTime localTime2;			// DB타입이 time(6)
	
	@Column(columnDefinition = "DATE")
	private LocalDate localDate1;			// DB타입이 DATE
	
	private LocalDate localDate2;			// DB타입이 date
	
	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime localDateTime1;			// DB타입이 TIMESTAMP
	
	private LocalDateTime localDateTime2;			// DB타입이 datetime(6)
}
