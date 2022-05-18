package com.ssafy.ssafit.model.service;

import java.util.List;

import com.ssafy.ssafit.model.dto.Video;

public interface VideoService {
	// 선택한 영상만
	List<Video> getVideoByPartName(String partName);
	// 전체 영상
	List<Video> getVideoList();
}
