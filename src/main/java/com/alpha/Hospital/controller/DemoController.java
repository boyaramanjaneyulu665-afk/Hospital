package com.alpha.Hospital.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class DemoController {
	@GetMapping("/ram")
	public void demo() {
		System.out.println(" is demo method executed");
	}


}
