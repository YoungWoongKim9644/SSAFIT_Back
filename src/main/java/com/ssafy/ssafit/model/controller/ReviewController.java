package com.ssafy.ssafit.model.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.Review;
import com.ssafy.ssafit.model.service.ReviewService;

@RestController
@RequestMapping("/review")
@CrossOrigin("*")
public class ReviewController {
	
	@Autowired
	ReviewService reviewService;
	
	@GetMapping("/detail/{no}")
	public ResponseEntity<Review> detail(@PathVariable int no){
		return new ResponseEntity<Review>(reviewService.getReviewByNo(no),
				HttpStatus.OK);
				
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Review>> list(@RequestParam(defaultValue = "") String mode,
											@RequestParam(defaultValue = "") String key
			){
		HashMap<String, String> params = new HashMap<>();
		params.put("mode", mode);
		params.put("key", key);
		return new ResponseEntity<List<Review>>(reviewService.getList(params),HttpStatus.OK);
	}
	
	@PostMapping("/write")
	public void write(@RequestBody Review review) {
		reviewService.writeReview(review);
	}
	
	@PutMapping("/update/{no}")
	public void update(@PathVariable int no, @RequestBody Review review) {
		reviewService.modifyReview(no, review);
	}
	
	@DeleteMapping("/delete")
	public void delete(int no) {
		reviewService.deleteReview(no);
	}

}
