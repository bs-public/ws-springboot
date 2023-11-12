package com;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	private final HelloService helloService;

	public HelloController(HelloService helloService) {
		this.helloService = helloService;
	}

	@RequestMapping("/greetings")
	public String getMessage() {
		return helloService.getMessage();
	}

}
