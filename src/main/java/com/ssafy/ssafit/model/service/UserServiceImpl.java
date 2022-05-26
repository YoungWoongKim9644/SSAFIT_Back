package com.ssafy.ssafit.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		Map<String,String> map = new HashMap<>();
		map.put("mode", "1");
		map.put("id", follower.getId());
		
		
		List<User> list = this.followList(map); //1은 내가 팔로우한 사람을 보여주기 
		
		
		
		for(User user: list) {
			if(followed.getId() == user.getId()) {
				return false;
			}
		}
		followDao.insertFollow(new Follow(0, follower.getId(), followed.getId()));
		return true;
	}
	

	@Override
	public User getUserById(String id) {
		return userDao.selectOne(id);
	}

	@Override
	public List<User> followList(Map<String, String> map) {
		return followDao.selectList(map);
	}

	@Override
	public List<String> searchUser(String id) {
		return userDao.searchUser(id);
	}
	
	public void unFollow(Follow follow){
		followDao.deleteFollow(follow);
	}
	

}
