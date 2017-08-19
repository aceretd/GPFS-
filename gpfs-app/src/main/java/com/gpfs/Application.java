package com.gpfs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@SpringBootApplication
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
