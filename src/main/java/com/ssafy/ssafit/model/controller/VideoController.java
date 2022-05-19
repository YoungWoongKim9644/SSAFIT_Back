package com.ssafy.ssafit.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.Video;
import com.ssafy.ssafit.model.service.VideoService;

@RestController
@RequestMapping("/video")
@CrossOrigin("*")
public class VideoController {
	
	@Autowired
	VideoService videoService;
	
	@GetMapping("/part/{name}")
	public ResponseEntity<List<Video>> part(@PathVariable String name) {
		return new ResponseEntity<List<Video>>(videoService.getVideoByPartName(name),
				HttpStatus.OK);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Video>> list() {
		return new ResponseEntity<List<Video>>(videoService.getVideoList(),
				HttpStatus.OK);
	}
}
