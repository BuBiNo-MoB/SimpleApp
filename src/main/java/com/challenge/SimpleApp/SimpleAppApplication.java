package com.challenge.SimpleApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SimpleAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(SimpleAppApplication.class, args);
	}
}

@RestController
class HelloController {
	@GetMapping("/")
	public String hello() {
		return "Ciao Felicitàè!!";
	}
}
