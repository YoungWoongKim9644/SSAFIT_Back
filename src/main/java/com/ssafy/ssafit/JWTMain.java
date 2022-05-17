package com.ssafy.ssafit;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTMain {
	
	public static void main(String[] args) throws UnsupportedEncodingException, InterruptedException {
		String token =
		Jwts.builder()
			.setHeaderParam("alg", "HS256")
			.setHeaderParam("typ","JWT")
			.claim("usserId","ssafy")
			.setExpiration(new Date(System.currentTimeMillis() + 3000)) //param 으로 주는 시간까지 유효
			.signWith(SignatureAlgorithm.HS256, "SSAFIT".getBytes("UTF-8"))
			.compact();
		
		//민감한 개인정보는 claim에 실으면 안된다. (ex 비밀번호)
		System.out.println(token);
		
		
		//토큰 decoding을 통한 원래 claim 값 출력 -> 로그인 과정
		System.out.println(
				new String(
						Base64.getDecoder().decode(
								token.split("\\.")[1]
								)
						)
				
				);
		
		Thread.sleep(4000);
		
		//토큰 유효성 검사 에러가 안나고, 예외가 안나면 문제가 유효 한 것! -> 로그인 후 어떤 요청을 할 때, 토큰을 실어보낼 때  
		Jws<Claims> claims =
		Jwts.parser()
			.setSigningKey("SSAFIT".getBytes("UTF-8"))
			.parseClaimsJws(token);
		
	}

}
