package com.gpfs.coa.service.custom.impl;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gpfs.coa.dto.ChartOfAccountInfo;
import com.gpfs.coa.dto.FSLevel2Info;
import com.gpfs.coa.dto.FSLevel6Info;
import com.gpfs.coa.model.ChartOfAccount;
import com.gpfs.coa.service.ChartOfAccountService;
import com.gpfs.coa.service.custom.ChartOfAccountServiceCustom;
import com.gpfs.core.service.GpfsJpaServiceCustomImpl;

/**
 *
 * @author Mark Martinez on Aug 5, 2017
 *
 */
public class ChartOfAccountServiceCustomImpl extends GpfsJpaServiceCustomImpl<ChartOfAccount, ChartOfAccountInfo, ChartOfAccountService>
	implements ChartOfAccountServiceCustom {

	private static final Logger LOG = LoggerFactory.getLogger(ChartOfAccountServiceCustomImpl.class);

	private ChartOfAccount getTemplate() {
		ChartOfAccount coaTemplate = repo.findOne(1l);
		return coaTemplate;
	}

	@Override
	public ChartOfAccountInfo getTemplateInfo() {
		LOG.info("Template requested!");

		ChartOfAccountInfo coaTemplate = toDto(getTemplate());

		coaTemplate.setId(null);
		//TODO there has to be a better way
		coaTemplate.getChildren().forEach(fs1 -> {
			fs1.setId(null);
			fs1.getChildren().forEach(fs2 -> {
				fs2.setId(null);
				fs2.getChildren().forEach(fs3 -> {
					fs3.setId(null);
					fs3.getChildren().forEach(fs4 -> {
						fs4.setId(null);
						fs4.getChildren().forEach(fs5 -> {
							FSLevel6Info initialChild = new FSLevel6Info();
							initialChild.setName("FS Level6 name");
							initialChild.setAccountNumber("1");
							initialChild.setCurrentYearAmount(BigDecimal.ZERO);
							initialChild.setPreviousYearAmount(BigDecimal.ZERO);

							fs5.setId(null);
							fs5.getChildren().add(initialChild);
						});
					});
				});
			});
		});

		return coaTemplate;
	}

}
