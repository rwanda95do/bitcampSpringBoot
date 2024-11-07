package user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import user.bean.UserDTO;
import user.dao.UserDAO;
import user.service.UserService;

@Controller
@RequestMapping(value = "user")
public class UserController {
	
	@Autowired
	private UserDAO userDAO;

	
	private UserService userService;
	//생성자인젝션: @Autowired를 대신하여 생성자 Injection
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	
	@GetMapping(value = "writeForm")
	public String writeForm() {
		return "user/writeForm";
	}
	
	//@GetMapping(value = "getExistId")
	@PostMapping(value = "getExistId")
	@ResponseBody
	public String getExistId(@RequestParam("id") String id) {
		return userService.getExistId(id);
	}
	
	@PostMapping(value = "write")
	@ResponseBody
	public void write(@ModelAttribute UserDTO userDTO) {
		userService.write(userDTO);
	}
	
	@PostMapping(value = "write2")
	public String write2(@ModelAttribute UserDTO userDTO) {
		System.out.println(userDTO);
		userService.write(userDTO);
		return "user/write";		
	}
	
	@GetMapping(value = "list")
	public String list(Model model) {
		
		List<UserDTO> list = userService.list();
		System.out.println(list);
		
		model.addAttribute("list", list);
		return "user/list";
	}
	
	@GetMapping(value = "profile")
	@ResponseBody
	public String profile(@RequestParam(name = "id", defaultValue="") String id, Model model) {
		System.out.println(id);
		UserDTO userDTO = userService.getUserDTO(id); 
		
		model.addAttribute("userDTO", userDTO);
		
		return "user/profile";
	}
}
