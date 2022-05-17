package com.ssafy.ssafit.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.UserDao;
import com.ssafy.ssafit.model.dto.User;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;

	@Override
	public boolean login(String id, String pw) {
		User user =  this.getUserById(id);
		if(user.getPw() == pw) return true;
		return false;
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void join(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean follow(User follower, User followed) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getUserById(String id) {
		return userDao.selectOne(id);
	}
	
	

}
