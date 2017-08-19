package com.gpfs.gpfs.service;

import java.util.Optional;

import com.gpfs.core.service.GpfsJpaService;
import com.gpfs.gpfs.Gpfs;
import com.gpfs.gpfs.service.custom.GpfsServiceCustom;

/**
 *
 * @author Mark Martinez on Aug 5, 2017
 *
 */
public interface GpfsService extends GpfsServiceCustom, GpfsJpaService<Gpfs> {

	Optional<Gpfs> findByCompanyIdAndYear(Long companyId, int year);

}
