package com.ssafy.ssafit.model.dao;

import java.util.List;

import com.ssafy.ssafit.model.dto.Video;

public interface VideoDao {
	// 운동부위별 비디오 리스트
	List<Video> selectList(String partName);
	
}
