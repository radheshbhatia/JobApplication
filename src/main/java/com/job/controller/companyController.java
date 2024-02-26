package com.job.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.job.entity.Company;
import com.job.service.CompanyService;

@RestController
@RequestMapping("/companies")
public class companyController {
	
	private CompanyService companyService;
	
	public companyController(CompanyService companyService) {
		this.companyService = companyService;
	}

	@GetMapping
	public ResponseEntity<List<Company>> getAllCompanies(){
		return new ResponseEntity<>(companyService.fetchAllCompanies(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Company> getCompany(@PathVariable long id){
		Company companyByid= companyService.getCompanyById(id);
		if(companyByid==null)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(companyByid,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> creatingCompany(@RequestBody Company company){
		companyService.createCompanies(company);
		return new ResponseEntity<>("created Successfully",HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateCompany(@PathVariable long id, @RequestBody Company updatedCompany){
		boolean Updated=companyService.UpdateCompanyById(id,updatedCompany);
		if(Updated)
			return new ResponseEntity<>("Updated Successfully",HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCompany(@PathVariable long id){
		companyService.deleteCompanyById(id);
		return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
			
	}
	

}
