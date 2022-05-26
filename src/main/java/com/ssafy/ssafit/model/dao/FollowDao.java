package com.ssafy.ssafit.model.dao;

import java.util.List;
import java.util.Map;

import com.ssafy.ssafit.model.dto.Follow;
import com.ssafy.ssafit.model.dto.User;

public interface FollowDao {
	
	void insertFollow(Follow follow);
	List<User> selectList(Map<String, String> map);
	void deleteFollow(Follow follow);
}
