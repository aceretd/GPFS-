package com.gpfs.company.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@RequestMapping("/companyform")
public class CompanyFormController {

	@RequestMapping(method = GET)
	public String companyForm() {
		return "company-form.html";
	}

}
