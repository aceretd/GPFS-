package com.gpfs.question.service.custom.impl;

import java.util.Optional;

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

    @Override
    public Optional<QuestionTemplateInfo> findInfoBySeries(int series) {
        return toDto(repo.findBySeries(series));
    }

}
