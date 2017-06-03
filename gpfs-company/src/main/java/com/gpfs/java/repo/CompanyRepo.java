package com.gpfs.java.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gpfs.company.Company;

public interface CompanyRepo  extends JpaRepository<Company, Long>{

}
