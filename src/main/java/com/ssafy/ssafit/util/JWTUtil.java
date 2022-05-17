package com.ssafy.ssafit.util;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {
//토큰 유효성 검사  + 토큰 반환하는 애 
		
	private static final String SALT = "SSAFIT";
	
		public String createToken(String claimId, String data) throws Exception {
			return Jwts.builder()
					.setHeaderParam("alg", "HS256")
					.setHeaderParam("typ","JWT")
					.claim(claimId,data)
					.signWith(SignatureAlgorithm.HS256, SALT.getBytes("UTF-8"))
					.compact();
		}
		
		public void valid(String token) throws Exception{
			Jwts.parser()
			.setSigningKey(SALT.getBytes("UTF-8"))
			.parseClaimsJws(token);
		}
	
	
}
