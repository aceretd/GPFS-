package com.gpfs.render.resource;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gpfs.render.service.GpfsRenderService;

@Controller
@RequestMapping("/render")
public class RenderResource {

	private static final Logger LOG = LoggerFactory.getLogger(RenderResource.class);

	@Autowired
	private GpfsRenderService service;

	@RequestMapping(value = "/gpfs/{companyId}/{year}", method = RequestMethod.GET)
    public ResponseEntity<String> ptSummary(HttpServletResponse response,
            @PathVariable Long companyId,
    		@PathVariable int year) throws Exception {
        LOG.debug("GPFS render requested");
        service.render(companyId, year, response);
 
        return new ResponseEntity<String>("OK", HttpStatus.OK);
    }

}
