package com.job.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.job.entity.Jobs;
import com.job.repository.JobRepository;

@Service
public class JobService {
	
	public JobService(JobRepository jobRepository) {
		this.jobRepository = jobRepository;
	}

	private JobRepository jobRepository;
	
	public List<Jobs> getJobs(){
		return jobRepository.findAll();
	}

	public void createAllJobs(Jobs job) {
		jobRepository.save(job);
	}

	public Jobs getJobById(Long id) {
		return jobRepository.findById(id).orElse(null);
	}

	public Boolean deleteJobById(Long id) {
		return deleteJobById(id);
	}

	public boolean updateJobById(long id, Jobs updatedjob) {
		Jobs updated=jobRepository.findById(id).orElse(null);
		updated.setDescription(updatedjob.getDescription());
		updated.setLocation(updatedjob.getLocation());
		updated.setTitle(updatedjob.getTitle());
		updated.setMaxSalary(updatedjob.getMaxSalary());
		updated.setMinSalary(updatedjob.getMinSalary());
		jobRepository.save(updated);
		return true;
	}
	
	
}
