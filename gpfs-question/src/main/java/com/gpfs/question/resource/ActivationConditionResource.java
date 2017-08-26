package com.gpfs.question.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activation")
public class ActivationConditionResource {

	@RequestMapping(method = POST)
	public ResponseEntity<Boolean> isActivated(@RequestBody String activationCondition) {
		
	}

}
