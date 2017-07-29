package com.gpfs.company.service;

import com.gpfs.company.model.Company;
import com.gpfs.company.service.custom.CompanyServiceCustom;
import com.gpfs.core.service.GpfsJpaService;

public interface CompanyService extends GpfsJpaService<Company>, CompanyServiceCustom {

}
