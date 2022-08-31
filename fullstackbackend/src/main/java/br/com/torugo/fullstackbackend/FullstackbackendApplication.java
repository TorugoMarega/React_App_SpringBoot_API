package br.com.torugo.fullstackbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController(value = "")
public class FullstackbackendApplication {

	@GetMapping
	public String testConnection(){
		return "API ONLINE!";
	}

	public static void main(String[] args) {
		SpringApplication.run(FullstackbackendApplication.class, args);
	}

}
