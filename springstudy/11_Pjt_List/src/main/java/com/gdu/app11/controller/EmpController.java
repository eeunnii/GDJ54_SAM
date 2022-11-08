package com.gdu.app11.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmpController {

	@GetMapping("/")
	public String welcome() {
		return "index";
	}
	
	@GetMapping("/emp/list")
	public String list() {
		
		return "employee/list";
	}
	
}
