package com.tw.apistackbase.api;

import com.tw.apistackbase.core.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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


    @GetMapping("/{companyName}")
    public List<Company> findCompanyByCompanyName(@PathVariable String companyName){
        List<Company> companies = companyRepository.findAll();
        return companies.stream().filter(company -> company.getName().equals(companyName)).collect(Collectors.toList());
    }

    @GetMapping("/reverse")
    public List<Company> findCompaniesAndReverse(){
        return companyRepository.findAll(Sort.by(Sort.Order.desc("id")));
    }

}
