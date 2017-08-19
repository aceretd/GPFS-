package com.gpfs.coa.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gpfs.coa.dto.ChartOfAccountInfo;
import com.gpfs.coa.service.ChartOfAccountService;
import com.gpfs.core.resource.BaseResource;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.http.ResponseEntity;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/coa")
public class ChartOfAccountResource extends BaseResource<ChartOfAccountInfo, ChartOfAccountService> {

	@RequestMapping(value = "/template", method = GET)
	public ResponseEntity<ChartOfAccountInfo> getTemplate() {
		return new ResponseEntity<ChartOfAccountInfo>(service.getTemplateInfo(), OK);
	}

}
