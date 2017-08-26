package com.gpfs.question.service;

import com.gpfs.core.service.GpfsJpaService;
import com.gpfs.question.QuestionTemplate;
import com.gpfs.question.service.custom.QuestionTemplateServiceCustom;

/**
 *
 * @author mbmartinez
 *
 */
public interface QuestionTemplateService extends QuestionTemplateServiceCustom, GpfsJpaService<QuestionTemplate> {

}
