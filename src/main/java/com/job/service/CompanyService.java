package com.job.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.job.entity.Company;
import com.job.repository.CompanyRepository;

@Service
public class CompanyService {
	
	private CompanyRepository companyRepository;

	public CompanyService(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

	public List<Company> fetchAllCompanies() {
		
		return companyRepository.findAll();
	}

	public void createCompanies(Company company) {
		companyRepository.save(company);
	}

	public Company getCompanyById(long id) {
		return companyRepository.findById(id).orElse(null);	
	}

	public boolean UpdateCompanyById(long id, Company updatedCompany) {
		Company companyToUpdate=companyRepository.findById(id).orElse(null);
		
		companyToUpdate.setDescription(updatedCompany.getDescription());
		companyToUpdate.setName(updatedCompany.getName());
		companyToUpdate.setJobs(updatedCompany.getJobs());
		companyRepository.save(companyToUpdate);
		return true;
	}

	public void deleteCompanyById(long id) {
		companyRepository.deleteById(id);
	}

}
