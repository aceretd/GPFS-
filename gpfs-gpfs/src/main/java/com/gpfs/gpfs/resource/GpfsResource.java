package com.gpfs.gpfs.resource;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gpfs.core.resource.BaseResource;
import com.gpfs.gpfs.dto.GpfsInfo;
import com.gpfs.gpfs.service.GpfsService;

@RestController
@RequestMapping("/gpfs")
public class GpfsResource extends BaseResource<GpfsInfo, GpfsService> {

	@RequestMapping(value = "/{companyId}/{year}", method = GET)
	public ResponseEntity<GpfsInfo> findByCompanyIdAndYear(@PathVariable Long companyId, @PathVariable int year) {
		return new ResponseEntity<>(service.findInfoByCompanyIdAndYear(companyId, year), OK);
	}

	@RequestMapping(method = POST)
	public ResponseEntity<GpfsInfo> save(@RequestBody GpfsInfo gpfs) {
		return new ResponseEntity<>(service.saveInfo(gpfs), OK);
	}

}
