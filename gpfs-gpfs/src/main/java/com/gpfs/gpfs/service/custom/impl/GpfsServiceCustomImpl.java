package com.gpfs.gpfs.service.custom.impl;

import java.util.Optional;

import org.assertj.core.util.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.gpfs.coa.model.ChartOfAccount;
import com.gpfs.coa.service.ChartOfAccountService;
import com.gpfs.core.service.GpfsJpaServiceCustomImpl;
import com.gpfs.gpfs.Gpfs;
import com.gpfs.gpfs.dto.GpfsInfo;
import com.gpfs.gpfs.service.GpfsService;
import com.gpfs.gpfs.service.custom.GpfsServiceCustom;

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
			}
		}
		return super.saveInfo(gpfs);
	}

	private void addFinancialStatements(GpfsInfo gpfs) {
		gpfs.setCoa(coaService.getTemplateInfo());
	}

}
