package thymeleaf.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;
import thymeleaf.bean.PersonDTO;

@Controller
public class ThymeleafController {
	public ThymeleafController() {
		System.out.println("ThymeleafController 생성자");
	}
	
	
	
	@GetMapping(value = "hithymeleaf")
	public String hithymeleaf(Model model) {
		model.addAttribute("say", "안녕하세요");
		return "basic/hithymeleaf";
	}
	
	
	
	@GetMapping(value = "literal")
	public String literal(Model model) {
		model.addAttribute("data", "스프링부트");
		return "basic/literal";
	}
	
	
	
	@GetMapping(value = "variable")
	public String variable(Model model) {
		
		PersonDTO aa = new PersonDTO("홍길동", 25);
		PersonDTO bb = new PersonDTO("김태리", 32);
		PersonDTO cc = new PersonDTO("이제훈", 40);
		
		model.addAttribute("aa", aa);

		List<PersonDTO> list = new ArrayList<>();
		list.add(aa);
		list.add(bb);
		list.add(cc);
		model.addAttribute("list", list);
		
		Map<String, Object> map = new HashMap<>();
		map.put("cc", cc);
		model.addAttribute("map", map);
		
		return "basic/variable";
	}
	
	
	@GetMapping(value = "operation")
	public String operation(Model model) {
		model.addAttribute("data", "스프링부트");
		return "basic/operation";
	}
	
	
	@GetMapping(value = "text_basic")
	public String text_basic(ModelMap modelMap) {
		
		modelMap.put("data", "Spring Boot");
		
		return "basic/text_basic";
	}
	
	
	@GetMapping(value = "attribute")
	public String attribute(ModelMap modelMap) {
		
		modelMap.put("data", "Spring Boot");
		
		return "basic/attribute";
	}


	@GetMapping(value = "ifcondition")
	public String ifcondition(Model model) {
		
		model.addAttribute("age", 15);
		model.addAttribute("movie", "베놈");
		model.addAttribute("today", "수요일");
		
		return "basic/ifcondition";
	}

	
	@GetMapping(value = "condition")
	public String condition(Model model) {
		
		PersonDTO aa = new PersonDTO("홍길동", 25);
		PersonDTO bb = new PersonDTO("김태리", 17);
		PersonDTO cc = new PersonDTO("이제훈", 40);
		
		List<PersonDTO> list = new ArrayList<>();
		list.add(aa);
		list.add(bb);
		list.add(cc);
		
		model.addAttribute("list", list);
		
		return "basic/condition";
	}

	
	@GetMapping(value = "each")
	public String each(Model model) {
		
		PersonDTO aa = new PersonDTO("홍길동", 25);
		PersonDTO bb = new PersonDTO("김태리", 17);
		PersonDTO cc = new PersonDTO("이제훈", 40);
		
		List<PersonDTO> list = new ArrayList<>();
		list.add(aa);
		list.add(bb);
		list.add(cc);
		
		model.addAttribute("list", list);
		
		return "basic/each";
	}
	
	
	@GetMapping(value = "block")
	public String block(Model model) {
		
		PersonDTO aa = new PersonDTO("홍길동", 25);
		PersonDTO bb = new PersonDTO("김태리", 17);
		PersonDTO cc = new PersonDTO("이제훈", 40);
		
		List<PersonDTO> list = new ArrayList<>();
		list.add(aa);
		list.add(bb);
		list.add(cc);
		
		model.addAttribute("list", list);
		
		return "basic/block";
	}
	
	
	@GetMapping(value = "link")
	public String link() {
		return "basic/link";
	}
	@GetMapping(value = "hello")
	@ResponseBody
	public String hello(@RequestParam(name = "name", defaultValue="noname") String name, 
			@RequestParam(name= "age", defaultValue="0") int age) {
		return name + "/" + age;
	}
	
	@GetMapping(value = "hello2/{name}/{age}")
	@ResponseBody
	public String hello2(@PathVariable(name="name") String name,@PathVariable(name="age") int age) {
		return name + "/" + age;
	}
	
	@GetMapping(value = "hello3/{name}")
	@ResponseBody
	public String hello3(@PathVariable("name") String name, @RequestParam("age") int age) {
		return name+ "/" + age;
	}
	
	@GetMapping(value = "select")
	@ResponseBody
	public String select() {
		return "select 요청";
	}
	@GetMapping(value = "insert")
	@ResponseBody
	public String insert(@RequestParam(name="pageno", defaultValue="1000") int pageno, Model model) {
		model.addAttribute("pageno", pageno);
		return "pageno = " + pageno;
	}
	@GetMapping(value = "/character/detail/{name}/{number}")
	@ResponseBody
	public String character_detail(@PathVariable("name") String name, @PathVariable("number") int number) {
		
		return "character_detail ";
	}
	
	
	
	@GetMapping(value = "basicobjects")
	public String basicobjects(HttpSession session, Model model) {	
		LocalDateTime startTime = LocalDateTime.now();
		model.addAttribute("startTime", startTime);
		
		model.addAttribute("str", "       spring boot          ");
		
		model.addAttribute("num", "123456789.123456");
		
		
		// 세션
		session.setAttribute("memId", "hong");
		session.setAttribute("memName", "홍");
		return "basic/basicobjects";
	}

	
	@GetMapping(value = "fragmentMain1")
	public String fragmentMain1() {
		return "basic/fragmentMain1";
	}
	@GetMapping(value = "fragmentMain2")
	public String fragmentMain2() {
		return "basic/fragmentMain2";
	}
	
}
