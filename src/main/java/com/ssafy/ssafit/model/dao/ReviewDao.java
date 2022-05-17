package com.ssafy.ssafit.model.dao;

import java.util.HashMap;
import java.util.List;

import com.ssafy.ssafit.model.dto.Review;

public interface ReviewDao {
	
	void insertReview(Review review);
	
 	void updateReview(Review review);
	
	void deleteReview(int no);
	
	List<Review> selectList(HashMap<String, String> params);
	
	Review selectOne(int no);

}
