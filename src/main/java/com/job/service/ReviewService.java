package com.job.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.job.entity.Company;
import com.job.entity.Review;
import com.job.repository.ReviewRepository;

@Service
public class ReviewService {
	
	private final ReviewRepository reviewRepository;
	
	private final CompanyService companyService;


	public ReviewService(ReviewRepository reviewRepository, CompanyService companyService) {
		this.reviewRepository = reviewRepository;
		this.companyService = companyService;
	}

	public List<Review> getAllReviewsByCompanyId(Long companyId) {
		return reviewRepository.findByCompanyId(companyId);
	}

	public void createReviewByCompanyId(Review review, Long companyId) {
		Company company=companyService.getCompanyById(companyId);
		if(company != null) {
			review.setCompany(company);
			reviewRepository.save(review);
		}
	}
}
