package com.gpfs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@SpringBootApplication
@Configuration
@EnableJpaRepositories
@Controller
public class Application {

	@RequestMapping(value = "/", method = GET)
	public String index() {
		return "index.html";
	}

	public static void main(String[] args) {
	    SpringApplication.run(Application.class, args);
    }

}
