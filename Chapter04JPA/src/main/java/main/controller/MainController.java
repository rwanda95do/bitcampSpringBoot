package main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller		// JSP로 빠져야하기때문에
public class MainController {
	
	@GetMapping(value = "/")
	public String index() {
		return "index";
	}
}
