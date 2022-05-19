package com.ssafy.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.FollowDao;
import com.ssafy.ssafit.model.dao.UserDao;
import com.ssafy.ssafit.model.dto.Follow;
import com.ssafy.ssafit.model.dto.User;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;
	@Autowired
	FollowDao followDao;
	
	@Override
	public boolean login(String id, String pw) {
		if(id == null || id.length() <= 0) return false;
		User user =  this.getUserById(id);
		if(user.getPw().equals(pw)) return true;
		return false;
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int join(User nUser) {
		System.out.println("here");
		User user = userDao.selectOne(nUser.getId());
		if(user != null) {
			System.out.println("중복된 아이디");
			return 0;
		}
		else {
			userDao.insertUser(nUser);
			
		}
		
		return 1;
	}

	@Override
	public boolean follow(User follower, User followed) {
		List<User> list = this.followList(follower);
		
		for(User user: list) {
			if(followed.getId() == user.getId()) {
				return false;
			}
		}
		followDao.insertFollow(new Follow(0, follower.getId(), followed.getId()));
		return true;
	}
	
	public List<User> followList(User follower){
		return followDao.selectList(follower.getId());
	}

	@Override
	public User getUserById(String id) {
		return userDao.selectOne(id);
	}
	
	

}
