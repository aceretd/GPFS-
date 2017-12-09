package com.gpfs.gpfs.service.custom;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.gpfs.core.service.GpfsJpaServiceCustom;
import com.gpfs.gpfs.Gpfs;
import com.gpfs.gpfs.dto.GpfsInfo;

/**
 *
 * @author Mark Martinez on Aug 5, 2017
 *
 */
public interface GpfsServiceCustom extends GpfsJpaServiceCustom<Gpfs, GpfsInfo> {

	GpfsInfo findInfoByCompanyIdAndYear(Long companyId, int year);
	GpfsInfo processCoaTemplate(long gpfsId, MultipartFile file) throws IOException;

}
