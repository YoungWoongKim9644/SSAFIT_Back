package com.ssafy.ssafit.model.dao;

import java.util.List;

import com.ssafy.ssafit.model.dto.Dibs;

public interface DibsDao {
	
	List<Dibs> selectList(String user);
	void insertDibs(Dibs dibs);
	void deleteDibs(Dibs dibs);

}
