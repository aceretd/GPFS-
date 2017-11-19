package com.gpfs.company.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gpfs.company.service.custom.CompanyServiceCustom;
import com.gpfs.core.dto.CompanyInfo;
import com.gpfs.core.resource.BaseResource;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/company")
public class CompanyResource extends BaseResource<CompanyInfo, CompanyServiceCustom> {

	private static final Logger LOG = LoggerFactory.getLogger(CompanyResource.class);

	@RequestMapping(method = POST)
	public ResponseEntity<CompanyInfo> save(@RequestBody CompanyInfo company) {
		LOG.debug("Company save request. company={}", company);
		return new ResponseEntity<>(service.saveInfo(company), OK);
	}

}
