package com.ssafy.ssafit.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.ReviewDao;
import com.ssafy.ssafit.model.dto.Review;

@Service("reviewService")
public class ReviewServiceImpl implements ReviewService{

	@Autowired
	ReviewDao reviewDao;

	@Override
	public void writeReview(Review review) {
		reviewDao.insertReview(review);
	}

	@Override
	public Review readReview(int no) {
		return reviewDao.selectOne(no);
	}

	@Override
	public void modifyReview(int no, Review review) {
		Review origin = reviewDao.selectOne(no);
		origin.setContent(review.getContent());
		origin.setTitle(review.getTitle());
		reviewDao.updateReview(origin);
	}

	@Override
	public void deleteReview(int no) {
		reviewDao.deleteReview(no);
	}

	/*
	 * @Override public void updateCnt(int no) { }
	 */
	
	@Override
	public Review getReviewByNo(int no) {
		Review review = reviewDao.selectOne(no);
		return review;
	}

	@Override
	public List<Review> getList(HashMap<String, String> params) {
		return reviewDao.selectList(params);
	}

}
