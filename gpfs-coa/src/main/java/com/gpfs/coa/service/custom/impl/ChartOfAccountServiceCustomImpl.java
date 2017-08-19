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
	public ChartOfAccountInfo getTemplate() {
		LOG.info("Template requested!");
		return repo.findOneInfo(1l);
	}

}
