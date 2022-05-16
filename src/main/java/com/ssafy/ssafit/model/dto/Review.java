package com.ssafy.ssafit.model.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Review {
	
	private int no;
	private String title;
	private String writer;
	private String regDate;
	private String content;
	private String videoTitle;

}
