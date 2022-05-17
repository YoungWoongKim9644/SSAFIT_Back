package com.ssafy.ssafit.model.service;

import com.ssafy.ssafit.model.dto.User;

public interface UserService {
	
	boolean login(String id, String pw);
	User getUserById(String id);
	void updateUser(User user);
	void join(User user);
	boolean follow(User follower, User followed);

}
