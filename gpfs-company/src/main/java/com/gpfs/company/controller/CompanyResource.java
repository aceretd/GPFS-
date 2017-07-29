package com.gpfs.company.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gpfs.company.service.custom.CompanyServiceCustom;
import com.gpfs.core.dto.CompanyInfo;
import com.gpfs.core.resource.BaseResource;

@RestController
@RequestMapping("/company")
public class CompanyResource extends BaseResource<CompanyInfo, CompanyServiceCustom> {

}
