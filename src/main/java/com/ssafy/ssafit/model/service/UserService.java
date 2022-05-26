package com.ssafy.ssafit.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.ssafit.model.dto.Follow;
import com.ssafy.ssafit.model.dto.User;

public interface UserService {
	
	boolean login(String id, String pw);
	User getUserById(String id);
	void updateUser(User user);
	int join(User user);
	boolean follow(User follower, User followed);
	List<User> followList(Map<String, String> map);
	List<String> searchUser(String id);
	void unFollow(Follow follow);

}
