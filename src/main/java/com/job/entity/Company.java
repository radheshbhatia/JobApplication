package com.job.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String Description;
	
	@JsonIgnore
	@OneToMany(mappedBy = "company")
	private List<Jobs> jobs;
	
	@OneToMany(mappedBy = "company")
	private List<Review> reviews;
	
	
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	public Company(Long id, String name, String description, List<Jobs> jobs) {
		this.id = id;
		this.name = name;
		Description = description;
		this.jobs = jobs;
	}
	public Company() {
	}
	public List<Jobs> getJobs() {
		return jobs;
	}
	public void setJobs(List<Jobs> jobs) {
		this.jobs = jobs;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	
}
