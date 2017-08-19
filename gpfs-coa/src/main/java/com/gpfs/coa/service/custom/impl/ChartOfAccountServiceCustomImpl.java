package com.gpfs.coa.service.custom.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gpfs.coa.dto.ChartOfAccountInfo;
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

	@Override
	public ChartOfAccount getTemplate() {
		ChartOfAccount coaTemplate = repo.findOne(1l);
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
							fs5.setId(null);
							fs5.getChildren().forEach(fs6 -> {
								fs6.setId(null);
							});
						});
					});
				});
			});
		});
		return coaTemplate;
	}

	@Override
	public ChartOfAccountInfo getTemplateInfo() {
		LOG.info("Template requested!");
		return toDto(getTemplate());
	}

}
