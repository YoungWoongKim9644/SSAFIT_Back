package com.ssafy.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.VideoDao;
import com.ssafy.ssafit.model.dto.Video;

@Service("videoService")
public class VideoServiceImpl implements VideoService {
	// Video
	@Autowired
	VideoDao videoDao;
	
	@Override
	public List<Video> getVideoByPartName(String partName) {
		return videoDao.selectList(partName);
	}

	@Override
	public List<Video> getVideoList() {
		return videoDao.videoList();
	}
}
