package com.gpfs.coa.resource;

import static org.springframework.http.HttpStatus.OK;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gpfs.coa.dto.ChartOfAccountInfo;
import com.gpfs.coa.service.ChartOfAccountService;
import com.gpfs.core.resource.BaseResource;

@RestController
@RequestMapping("/coa")
public class ChartOfAccountResource extends BaseResource<ChartOfAccountInfo, ChartOfAccountService> {

	@GetMapping("/template")
	public ResponseEntity<ChartOfAccountInfo> getTemplate() {
		return new ResponseEntity<ChartOfAccountInfo>(service.getTemplateInfo(), OK);
	}

}
