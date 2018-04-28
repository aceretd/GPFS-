package com.gpfs.question.service;

import java.util.Optional;

import com.gpfs.core.service.GpfsJpaService;
import com.gpfs.question.QuestionTemplate;
import com.gpfs.question.service.custom.QuestionTemplateServiceCustom;

/**
 *
 * @author mbmartinez
 *
 */
public interface QuestionTemplateService extends QuestionTemplateServiceCustom, GpfsJpaService<QuestionTemplate> {

    Optional<QuestionTemplate> findBySeries(int series);

}
