package com.gpfs.question.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gpfs.core.resource.BaseResource;
import com.gpfs.question.dto.QuestionTemplateInfo;
import com.gpfs.question.service.QuestionTemplateService;

@RestController
@RequestMapping("/question")
public class QuestionResource extends BaseResource<QuestionTemplateInfo, QuestionTemplateService> {

}
