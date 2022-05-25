package com.ssafy.ssafit.model.service;

import java.util.List;

import com.ssafy.ssafit.model.dto.Dibs;

public interface DibsService {
	
	void makeDibs(Dibs dibs);
	List<Dibs> getDibs(String user);
	void deleteDibs(Dibs dibs);

}
