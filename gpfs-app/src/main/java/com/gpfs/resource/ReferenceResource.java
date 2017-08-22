package com.gpfs.resource;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gpfs.question.dto.PrincipalActivityInfo;
import com.gpfs.question.service.PrincipalActivityService;

@RestController
@RequestMapping("/reference")
public class ReferenceResource {

	@Autowired
	private PrincipalActivityService principalActivityService;

    @RequestMapping(value = "/principal-activity", method = GET)
    public ResponseEntity<Page<PrincipalActivityInfo>> rqlSearch(@RequestParam(required = false) String term, Pageable page) {
        return new ResponseEntity<>(principalActivityService.rqlSearch(term, principalActivityService.getFieldMapping(), page), OK);
    }

}
