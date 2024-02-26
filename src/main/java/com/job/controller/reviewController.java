package com.job.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.job.entity.Review;
import com.job.service.ReviewService;


@RestController
@RequestMapping("company/{companyId}")
public class reviewController {
	
	private ReviewService reviewService;
	
	public reviewController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}

	@GetMapping("/reviews")
	public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId){
		
		return new ResponseEntity<>(reviewService.getAllReviewsByCompanyId(companyId),HttpStatus.OK);
	}
	@PostMapping("/reviews")
	public ResponseEntity<String> creatingReview(@RequestBody Review review, @PathVariable Long companyId){
		reviewService.createReviewByCompanyId(review,companyId);
		return new ResponseEntity<>("created successfully", HttpStatus.CREATED);
	}
	
	
}
