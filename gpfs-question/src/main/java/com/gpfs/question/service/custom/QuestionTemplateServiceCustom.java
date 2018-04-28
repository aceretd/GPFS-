package com.gpfs.question.service.custom;

import java.util.Optional;

import com.gpfs.core.service.GpfsJpaServiceCustom;
import com.gpfs.question.QuestionTemplate;
import com.gpfs.question.dto.QuestionTemplateInfo;

public interface QuestionTemplateServiceCustom extends GpfsJpaServiceCustom<QuestionTemplate, QuestionTemplateInfo> {

    Optional<QuestionTemplateInfo> findInfoBySeries(int series);

}
