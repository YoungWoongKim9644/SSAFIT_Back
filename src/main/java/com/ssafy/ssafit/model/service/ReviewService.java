package com.ssafy.ssafit.model.service;

import java.util.HashMap;
import java.util.List;

import com.ssafy.ssafit.model.dto.Review;

public interface ReviewService {
	
	List<Review> getList(HashMap<String, String> params);
	Review getReviewByNo(int no);
	void writeReview(Review review);
	void modifyReview(int no, Review review);
	void deleteReview(int no);
	//void updateCnt(int no);
	

}
