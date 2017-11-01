package com.gpfs.gpfs.dto;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Mark Martinez on Nov 1, 2017
 *
 */
public class CoaUploadDto {

	private Long gpfsId;
	private MultipartFile file;

	public Long getGpfsId() {
		return gpfsId;
	}
	public void setGpfsId(Long gpfsId) {
		this.gpfsId = gpfsId;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}

}
