package com.ssafy.ssafit.model.dao;

import java.util.List;

import com.ssafy.ssafit.model.dto.Review;
import com.ssafy.ssafit.model.dto.User;

public interface UserDao {
	
	//회원가입 용
	int insertUser(User user);
	//로그인 용
	User selectOne(String id);
	//회원정보 변경 용
 	void updateUser(User user);


}
