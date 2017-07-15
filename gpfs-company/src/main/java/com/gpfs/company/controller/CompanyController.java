package com.gpfs.company.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Company>> getlistofcompanies() {
		List<Company> companies = repo.findAll();
		return new ResponseEntity<>(companies, HttpStatus.OK);
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
