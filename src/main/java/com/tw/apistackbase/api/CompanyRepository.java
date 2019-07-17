package com.tw.apistackbase.api;

import com.tw.apistackbase.core.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {


   // Company addCompany(Company company);
}
