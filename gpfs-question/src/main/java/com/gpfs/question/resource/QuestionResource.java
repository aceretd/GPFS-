package com.gpfs.question.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import static org.springframework.http.HttpStatus.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import com.gpfs.question.Question;
import com.gpfs.question.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionResource {

	@Autowired
	private QuestionService service;

	@RequestMapping(method = GET)
	public ResponseEntity<Page<Question>> findAll(Pageable page) {
		return new ResponseEntity<>(service.findAll(page), OK);
	}

}
