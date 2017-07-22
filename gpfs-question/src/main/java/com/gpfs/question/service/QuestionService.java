package com.gpfs.question.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gpfs.question.QuestionTemplate;

/**
 *
 * @author mbmartinez
 *
 */
public interface QuestionService extends JpaRepository<QuestionTemplate, Long> {

}
