package com.gpfs.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.*;
@RestController
public class HelloworldController {
	@RequestMapping(value = "/hello", method = GET)
	public String login() {
	    return "Hello World";
	}
}

