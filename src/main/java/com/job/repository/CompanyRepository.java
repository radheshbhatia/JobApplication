package com.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.job.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
