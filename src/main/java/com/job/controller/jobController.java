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

import com.job.entity.Jobs;
import com.job.service.JobService;


@RestController
@RequestMapping("/jobs")
public class jobController {
	
	private JobService jobService;
		
	public jobController(JobService jobService) {
		this.jobService = jobService;
	}

	@GetMapping
	public ResponseEntity<List<Jobs>> getAllJobs(){
		return new ResponseEntity<>(jobService.getJobs(),HttpStatus.OK);
	}	
	@GetMapping("/{id}")
	public ResponseEntity<Jobs> getJobId(@PathVariable Long id){
		Jobs job =jobService.getJobById(id);
		if(job==null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(job,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> fetchJobs(@RequestBody Jobs job){
		jobService.createAllJobs(job);
		return new ResponseEntity<>("created successfully", HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updatedJob(@PathVariable long id, @RequestBody Jobs Updatedjob){
		
		boolean Updated=jobService.updateJobById(id, Updatedjob);
		
		if(!Updated)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>("Updated sucessfully", HttpStatus.OK);		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteJobId(@PathVariable Long id){
		Boolean job=jobService.deleteJobById(id);
		
		if(job)
			return new ResponseEntity<>("Deleted sucessfully", HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}
