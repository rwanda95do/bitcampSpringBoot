package member.bean;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
public class MemberDTO {

	private int seq;
	private String id;
	private String pwd;
	private String name;
}