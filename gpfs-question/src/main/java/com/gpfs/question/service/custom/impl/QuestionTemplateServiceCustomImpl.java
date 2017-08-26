package com.gpfs.question.service.custom.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gpfs.core.service.GpfsJpaServiceCustomImpl;
import com.gpfs.question.QuestionTemplate;
import com.gpfs.question.dto.QuestionTemplateInfo;
import com.gpfs.question.service.QuestionTemplateService;
import com.gpfs.question.service.custom.QuestionTemplateServiceCustom;

/**
 *
 * @author Mark Martinez on Aug 5, 2017
 *
 */
public class QuestionTemplateServiceCustomImpl extends GpfsJpaServiceCustomImpl<QuestionTemplate, QuestionTemplateInfo, QuestionTemplateService>
	implements QuestionTemplateServiceCustom {

	private static final Logger LOG = LoggerFactory.getLogger(QuestionTemplateServiceCustomImpl.class);

}
