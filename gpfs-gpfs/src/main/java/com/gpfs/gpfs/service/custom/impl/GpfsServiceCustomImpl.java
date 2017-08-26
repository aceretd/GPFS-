package com.gpfs.gpfs.service.custom.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import com.gpfs.coa.service.ChartOfAccountService;
import com.gpfs.core.service.GpfsJpaServiceCustomImpl;
import com.gpfs.gpfs.Gpfs;
import com.gpfs.gpfs.dto.GpfsInfo;
import com.gpfs.gpfs.dto.NoteInfo;
import com.gpfs.gpfs.dto.QuestionAnswerPairInfo;
import com.gpfs.gpfs.service.GpfsService;
import com.gpfs.gpfs.service.custom.GpfsServiceCustom;
import com.gpfs.question.dto.QuestionTemplateInfo;
import com.gpfs.question.service.QuestionTemplateService;

/**
 *
 * @author Mark Martinez on Aug 5, 2017
 *
 */
public class GpfsServiceCustomImpl extends GpfsJpaServiceCustomImpl<Gpfs, GpfsInfo, GpfsService>
	implements GpfsServiceCustom {

	private static final Logger LOG = LoggerFactory.getLogger(GpfsServiceCustomImpl.class);

	@Autowired
	private ChartOfAccountService coaService;

	@Autowired
	private QuestionTemplateService questionService;

	@Override
	public GpfsInfo findInfoByCompanyIdAndYear(Long companyId, int year) {
		return toDto(repo.findByCompanyIdAndYear(companyId, year).get());
	}

	@Override
	public GpfsInfo saveInfo(GpfsInfo gpfs) {
		LOG.debug("Save request. gpfs={}", gpfs);

		if (null == gpfs.getId()) {
			LOG.debug("GPFS create request. Will return existing if available, create if not found");
			Optional<Gpfs> existing = repo.findByCompanyIdAndYear(gpfs.getCompany().getId(), gpfs.getYear());
			if (existing.isPresent()) {
				LOG.debug("Returning existing GPFS");
				return toDto(existing.get());
			} else {
				addFinancialStatements(gpfs);
				addQuestions(gpfs);
			}
		}
		return super.saveInfo(gpfs);
	}

	private void addFinancialStatements(GpfsInfo gpfs) {
		gpfs.setCoa(coaService.getTemplateInfo());
	}

	private void addQuestions(GpfsInfo gpfs) {
		List<QuestionTemplateInfo> questions = questionService.findAllInfo(new Sort("note", "series"));
		for (QuestionTemplateInfo question : questions) {
			LOG.debug("Adding quesetion to new GPFS. question={}", question);
			Optional<NoteInfo> noteOpt = gpfs.findNote(question.getNote());
			NoteInfo note;
			if (noteOpt.isPresent()) {
				note = noteOpt.get();
			} else {
				note = new NoteInfo();
				note.setIndex(question.getNote());
				gpfs.getNotes().add(note);
			}
			QuestionAnswerPairInfo qapi = new QuestionAnswerPairInfo();
			qapi.setQuestion(question);
			qapi.setAnswer(null);
			qapi.setEditTemplateMode(false);
			note.getQuestions().add(qapi);
		}
	}
}
