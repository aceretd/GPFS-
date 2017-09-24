package com.gpfs.render.service;

import javax.servlet.http.HttpServletResponse;

public interface GpfsRenderService {

	public void preview(Long companyId, int year, HttpServletResponse response) throws Exception;
	public void render(Long companyId, int year, HttpServletResponse response) throws Exception;

}
