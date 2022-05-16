package com.ssafy.ssafit.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Video {
	
	private String title;
	private String fitPartName;
	private String youtubeId;
	private String channelName;
	private int viewCnt;

}
