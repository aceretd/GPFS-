package com.gpfs.gpfs.resource;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gpfs.core.resource.BaseResource;
import com.gpfs.gpfs.dto.CoaUploadDto;
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

	@RequestMapping(value = "/coa-template", method = POST)
	public ResponseEntity<GpfsInfo> uploadCoa(CoaUploadDto uploadDto) throws IOException {
		return new ResponseEntity<>(service.saveProductCustom(uploadDto), OK);
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
