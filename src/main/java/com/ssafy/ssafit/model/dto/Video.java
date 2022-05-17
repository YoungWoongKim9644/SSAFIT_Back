package com.ssafy.ssafit.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Video {
	// fitpart 테이블
	private int code;
	private String partName;
	// video 테이블
	private String title;
	private int fitPartName;
	private String youtubeId;
	private String channelName;
	private int viewCnt;

}
