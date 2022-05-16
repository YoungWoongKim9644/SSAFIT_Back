package com.ssafy.ssafit.model.dao;

import java.util.HashMap;
import java.util.List;

import com.ssafy.ssafit.model.dto.Review;

public interface ReviewDao {
	
	int insertReview(Review review);
	
 	int updateReview(Review review);
	
	int deleteReview();
	
	List<Review> selectList(HashMap<String, String> params);
	
	Review selectOne(int no);

}
