package com.gpfs.coa.service.custom;

import com.gpfs.coa.dto.ChartOfAccountInfo;
import com.gpfs.coa.model.ChartOfAccount;
import com.gpfs.core.service.GpfsJpaServiceCustom;

/**
 *
 * @author Mark Martinez on Aug 5, 2017
 *
 */
public interface ChartOfAccountServiceCustom extends GpfsJpaServiceCustom<ChartOfAccount, ChartOfAccountInfo> {

	ChartOfAccountInfo getTemplateInfo();

}
