package com.ssafy.ssafit.model.service;

import java.util.List;

import com.ssafy.ssafit.model.dto.Video;

public interface VideoService {
	// Video
	List<Video> getVideoByPartName(String partName);
}
