package com.gpfs.question.resource;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gpfs.core.resource.BaseResource;
import com.gpfs.question.dto.QuestionTemplateInfo;
import com.gpfs.question.service.QuestionTemplateService;

@RestController
@RequestMapping("/question")
public class QuestionResource extends BaseResource<QuestionTemplateInfo, QuestionTemplateService> {

    private static final Logger LOG = LoggerFactory.getLogger(QuestionResource.class);

    @PostMapping
    public ResponseEntity<QuestionTemplateInfo> save(@RequestBody @Valid QuestionTemplateInfo question) {
        LOG.info("Save question request. question={}", question);
        return new ResponseEntity<>(service.saveInfo(question), OK);
    }

    @GetMapping("/series/{series}")
    public ResponseEntity<QuestionTemplateInfo> findBySeries(@PathVariable int series) {
        return service.findInfoBySeries(series)
                .map(questionInfo -> new ResponseEntity<>(questionInfo, OK))
                .orElse(new ResponseEntity<>(null, NOT_FOUND));
    }

    @PostMapping("/backup")
    public ResponseEntity<String> upload(MultipartFile file) {
        LOG.info("Question backup upload. file={}", file);
        return new ResponseEntity<>("Ok!", OK);
    }

}
