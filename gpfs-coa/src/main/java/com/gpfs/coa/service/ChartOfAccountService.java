package com.gpfs.coa.service;

import com.gpfs.coa.model.ChartOfAccount;
import com.gpfs.coa.service.custom.ChartOfAccountServiceCustom;
import com.gpfs.core.service.GpfsJpaService;

/**
 *
 * @author Mark Martinez on Aug 5, 2017
 *
 */
public interface ChartOfAccountService extends ChartOfAccountServiceCustom, GpfsJpaService<ChartOfAccount> {

}
