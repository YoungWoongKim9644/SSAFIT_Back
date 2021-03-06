package com.ssafy.ssafit.model.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.Follow;
import com.ssafy.ssafit.model.dto.User;
import com.ssafy.ssafit.model.service.UserService;
import com.ssafy.ssafit.util.JWTUtil;

import lombok.extern.slf4j.Slf4j;

//Controller <- Service <- Dao <- Mapper <- Dto

@Slf4j
@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	private static final String FAIL = "fail";
	private static final String SUCCESS = "success";
	
	@Autowired
	private JWTUtil jwtUtil;
	@Autowired
	private UserService userService;
	
	//넘어온 파라미터가 json일때, 파라미터에 제대로 파싱하려면 requestbody 어노테이션을 넣어야한다.
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody User user){
		log.info(user.toString());

		HttpStatus status = null;
		HashMap<String, Object> result = new HashMap<>();
		try {
			// user 정보를 이용해서 데이터베이스 확인
			// 존재하면 토큰 생성해서 결과 넣어서 반환
			if(userService.login(user.getId(), user.getPw())) //db에 존재 할 때!
			{
					result.put("auth-token", jwtUtil.createToken("userId", user.getId()));
					result.put("message", SUCCESS);
					status = HttpStatus.ACCEPTED;
					System.out.println("success");
			}else {
				result.put("message", FAIL);
				status = HttpStatus.ACCEPTED;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("exception");
			status  = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		return new ResponseEntity<Map<String,Object>>(result, status);
		
	}

	//유효성 검사는 프론트 단에서 처리
	@PostMapping("/join")
	public int join(@RequestBody User user) {
		return userService.join(user);
	}
	//1이면 ok, 0이면 중복 
	
	@PostMapping("/follower/insert")
	public ResponseEntity<Boolean> follow(@RequestBody Follow follow) {
		System.out.println(follow.toString());
		User follower = userService.getUserById(follow.getFollowerId());
		User followed = userService.getUserById(follow.getFollowedId());
		
		if(userService.follow(follower, followed)) {
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}
		return new ResponseEntity<Boolean>(false, HttpStatus.OK);
	}
	
	@PostMapping("/follower/list")
	public ResponseEntity<List<User>>followerList(@RequestBody Map<String,String> map) {
		System.out.println(map.toString());
		return new ResponseEntity<List<User>>(userService.followList(map), HttpStatus.OK);
	}
	
	@PostMapping("/search")
	public ResponseEntity<List<String>> search(@RequestBody String id){
		id = id.replaceAll("\"", "");
		return new ResponseEntity<List<String>>(userService.searchUser(id), HttpStatus.OK);
	}
	
	@PutMapping("/follower/update")
	public void followUpdate(@RequestBody Follow follow) {
		userService.unFollow(follow);
	}
	
}
