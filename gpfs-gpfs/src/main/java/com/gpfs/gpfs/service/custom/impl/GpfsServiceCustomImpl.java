package com.gpfs.gpfs.service.custom.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.multipart.MultipartFile;

import com.gpfs.coa.dto.ChartOfAccountInfo;
import com.gpfs.coa.model.ChartOfAccount;
import com.gpfs.coa.service.ChartOfAccountService;
import com.gpfs.core.service.GpfsJpaServiceCustomImpl;
import com.gpfs.gpfs.Gpfs;
import com.gpfs.gpfs.Note;
import com.gpfs.gpfs.dto.CoaUploadDto;
import com.gpfs.gpfs.dto.GpfsInfo;
import com.gpfs.gpfs.dto.NoteInfo;
import com.gpfs.gpfs.dto.QuestionAnswerPairInfo;
import com.gpfs.gpfs.service.GpfsService;
import com.gpfs.gpfs.service.custom.GpfsServiceCustom;
import com.gpfs.gpfs.util.QapComparator;
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
		Gpfs gpfs = repo.findByCompanyIdAndYear(companyId, year).get();
		for (Note note : gpfs.getNotes()) {
			note.getQuestions().sort(new QapComparator());
		}
		return toDto(gpfs);
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

	@Override
	public GpfsInfo processCoaTemplate(long gpfsId, MultipartFile file) throws IOException {
		GpfsInfo gpfs = repo.findOneInfo(gpfsId);
		if (null == gpfs) {
			throw new IllegalArgumentException("GPFS not found with id={}" + gpfsId);
		}

		XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
		ChartOfAccountInfo coa = ChartOfAccountInfo.fromWorkbook(gpfs.getCoa(), workbook);
		gpfs.setCoa(coa);

		return repo.saveInfo(gpfs);
	}
}
