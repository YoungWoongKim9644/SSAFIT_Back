package com.ssafy.ssafit.model.dao;

import java.util.List;

import com.ssafy.ssafit.model.dto.Review;
import com.ssafy.ssafit.model.dto.User;

public interface UserDao {
	
	//회원가입 용
	int insertUser(Review review);
	//로그인 용
	User selectOne(User user);
	//회원정보 변경 용
 	int updateUser(Review review);


}
