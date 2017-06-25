package com.gpfs.question.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gpfs.question.Question;

/**
 *
 * @author mbmartinez
 *
 */
public interface QuestionService extends JpaRepository<Question, Long> {

}
