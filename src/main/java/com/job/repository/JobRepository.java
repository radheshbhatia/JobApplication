package com.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.job.entity.Jobs;

public interface JobRepository extends JpaRepository<Jobs, Long> {

}
