package com.gpfs.gpfs.resource;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gpfs.core.resource.BaseResource;
import com.gpfs.gpfs.dto.GpfsInfo;
import com.gpfs.gpfs.service.GpfsService;

@RestController
@RequestMapping("/gpfs")
public class GpfsResource extends BaseResource<GpfsInfo, GpfsService> {

	private static final Logger LOG = LoggerFactory.getLogger(GpfsResource.class);

	@RequestMapping(value = "/{companyId}/{year}", method = GET)
	public ResponseEntity<GpfsInfo> findByCompanyIdAndYear(@PathVariable Long companyId, @PathVariable int year) {
		return new ResponseEntity<>(service.findInfoByCompanyIdAndYear(companyId, year), OK);
	}

	@RequestMapping(method = POST)
	public ResponseEntity<GpfsInfo> save(@RequestBody GpfsInfo gpfs) {
		return new ResponseEntity<>(service.saveInfo(gpfs), OK);
	}

	@PostMapping("/coa-template/{gpfsId}")
	public ResponseEntity<GpfsInfo> uploadCoa(@PathVariable long gpfsId, @RequestParam MultipartFile file) throws IOException {
		LOG.info("COA upload request received. gpfsId={}", gpfsId);
		return new ResponseEntity<>(service.processCoaTemplate(gpfsId, file), OK);
	}

	@RequestMapping(value = "/coa-template/{companyId}/{year}", method = GET)
	public ResponseEntity<byte[]> getTemplateXls(@PathVariable Long companyId, @PathVariable int year, HttpServletResponse response) throws IOException {
		GpfsInfo gpfs = service.findInfoByCompanyIdAndYear(companyId, year);
		XSSFWorkbook report = gpfs.getCoa().toWorkbook();
        response.setHeader("Content-disposition", "attachment; filename=COA " + gpfs.getCompany().getName() + " - " + year + ".xlsx");
        if (null != report) {
            report.write(response.getOutputStream());
        }
        return new ResponseEntity(HttpStatus.OK);
	}

}
