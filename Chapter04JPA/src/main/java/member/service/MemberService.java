package member.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import member.bean.MemberDTO;
import member.entity.MemberEntity;

public interface MemberService {

	public String isExistId(String id);

	public void write(MemberEntity memberEntity);

	public  Map<String, Object> getMemberlist(Pageable pageable);

	public List<MemberEntity> getSearchList(String columnName, String value);



}
