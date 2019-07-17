package com.tw.apistackbase.api;

import com.tw.apistackbase.core.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companies")
public class CompanyResource {

    @Autowired
    CompanyRepository companyRepository;

    @GetMapping(produces = {"application/json"})
    public Iterable<Company> list() {
        return companyRepository.findAll();
    }
    
    @PostMapping(produces = {"application/json"})
    public Company add(@RequestBody Company company) {
        return companyRepository.save(company);
    }

    @PutMapping
    public Company update(@RequestBody Company company){
        return companyRepository.save(company);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        companyRepository.deleteById(id);
    }


}
