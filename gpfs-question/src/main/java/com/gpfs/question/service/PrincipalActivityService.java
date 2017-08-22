package com.gpfs.question.service;

import com.gpfs.core.service.GpfsJpaService;
import com.gpfs.question.service.custom.PrincipalActivityServiceCustom;
import com.gpfs.reference.PrincipalActivity;

/**
 *
 * @author mbmartinez
 *
 */
public interface PrincipalActivityService extends PrincipalActivityServiceCustom, GpfsJpaService<PrincipalActivity> {

}
