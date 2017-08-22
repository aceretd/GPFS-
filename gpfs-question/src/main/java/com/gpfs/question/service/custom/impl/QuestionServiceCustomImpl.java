package com.gpfs.question.service.custom.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gpfs.core.service.GpfsJpaServiceCustomImpl;
import com.gpfs.question.QuestionTemplate;
import com.gpfs.question.dto.QuestionTemplateInfo;
import com.gpfs.question.service.QuestionService;
import com.gpfs.question.service.custom.QuestionServiceCustom;

/**
 *
 * @author Mark Martinez on Aug 5, 2017
 *
 */
public class QuestionServiceCustomImpl extends GpfsJpaServiceCustomImpl<QuestionTemplate, QuestionTemplateInfo, QuestionService>
	implements QuestionServiceCustom {

	private static final Logger LOG = LoggerFactory.getLogger(QuestionServiceCustomImpl.class);

}
