package com.gpfs.render.resource;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gpfs.render.service.GpfsRenderService;

@RestController
@RequestMapping("/preview")
public class PreviewResource {

	private static final Logger LOG = LoggerFactory.getLogger(PreviewResource.class);

	@Autowired
	private GpfsRenderService service;

	@RequestMapping("/gpfs/{companyId}/{year}")
	public void gpfsPreview(@PathVariable Long companyId, @PathVariable int year, HttpServletResponse response) throws Exception {
		LOG.debug("GPFS preview requested");
		service.preview(companyId, year, response);

		//return new ResponseEntity<String>("OK", HttpStatus.OK);
	}

	@RequestMapping("/gpfs/{companyId}/{year}/{note}")
	public void gpfsPreviewNote(@PathVariable Long companyId, @PathVariable int year, @PathVariable int note, HttpServletResponse response) throws Exception {
		LOG.debug("GPFS preview requested");
		service.preview(companyId, year, note, response);
	}

}
