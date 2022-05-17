package com.ssafy.ssafit.model.dao;

import java.util.List;

import com.ssafy.ssafit.model.dto.Follow;
import com.ssafy.ssafit.model.dto.User;

public interface FollowDao {
	
	List<User> selectList(String followerId);
	void insertFollow(Follow follow);
}
