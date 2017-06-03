package com.gpfs.company.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gpfs.company.Company;
import com.gpfs.java.repo.CompanyRepo;
@RestController
public class CompanyController {

@Autowired	
	CompanyRepo repo; 
	
	@RequestMapping(value = "/companies", method = GET)
	public List getlistofcompanies() {
	    List companies=new ArrayList();
	    Company company1=new Company();
	    company1.setName("test name");
	    companies.add(company1);
	    return companies;
	}
	
	@RequestMapping(value = "/savecompany", method = POST)
	public String savenewcompany(@RequestParam String name, @RequestParam String tin) {
	   
	    Company company1=new Company();
	    company1.setName(name);
	    company1.setTin(tin);
	    repo.save(company1);
	    return "Ok";
	}
}
