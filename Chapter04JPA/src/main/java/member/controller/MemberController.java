package member.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import member.bean.MemberDTO;
import member.entity.MemberEntity;
import member.service.MemberService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping(value = "/member")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	
	@GetMapping(value = "/writeForm")
	public String writeForm() {
		return "member/writeForm";
	}
	

	@PostMapping(value = "/isExistId")
	@ResponseBody
	public String isExistId(@RequestParam(value = "id") String id) {
		return memberService.isExistId(id);
	}
	

	@PostMapping(value = "/write")
	@ResponseBody
	public void write(@ModelAttribute MemberEntity memberEntity) {
		memberService.write(memberEntity);
	}
	

	@GetMapping(value = "/list")
	public String list(@RequestParam(value = "page", required = false, defaultValue = "0")String page, 
			@PageableDefault(page=0, size = 3, sort = "name", direction = Sort.Direction.DESC) Pageable pageable, 
			Model model) {
		
		Map<String, Object> map = memberService.getMemberlist(pageable);
		System.out.println("map : "+map);
		
		model.addAttribute("map", map);
		
		return "member/list";
	}
	
	

	@GetMapping(value = "/getSearchList")
	@ResponseBody
	public List<MemberEntity> getSearchList(@RequestParam(value = "columnName") String columnName, @RequestParam(value = "value") String value) {
		return memberService.getSearchList(columnName, value);
		
	}
	
}



