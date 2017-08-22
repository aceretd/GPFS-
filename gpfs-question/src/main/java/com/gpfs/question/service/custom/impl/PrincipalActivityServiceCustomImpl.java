package com.gpfs.question.service.custom.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gpfs.core.service.GpfsJpaServiceCustomImpl;
import com.gpfs.question.dto.PrincipalActivityInfo;
import com.gpfs.question.service.PrincipalActivityService;
import com.gpfs.question.service.custom.PrincipalActivityServiceCustom;
import com.gpfs.reference.PrincipalActivity;

/**
 *
 * @author Mark Martinez on Aug 5, 2017
 *
 */
public class PrincipalActivityServiceCustomImpl extends GpfsJpaServiceCustomImpl<PrincipalActivity, PrincipalActivityInfo, PrincipalActivityService>
	implements PrincipalActivityServiceCustom {

	private static final Logger LOG = LoggerFactory.getLogger(PrincipalActivityServiceCustomImpl.class);

}
