package com.ssafy.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.DibsDao;
import com.ssafy.ssafit.model.dao.ReviewDao;
import com.ssafy.ssafit.model.dto.Dibs;
import com.ssafy.ssafit.model.dto.Review;

@Service("dibsService")
public class DibsServiceImpl implements DibsService{
	
	@Autowired
	DibsDao dibsDao;
	
	public void makeDibs(Dibs dibs) {
		dibsDao.insertDibs(dibs);
	}
	
	public List<Dibs> getDibs(String user) {
		return dibsDao.selectList(user);
	}

	@Override
	public void deleteDibs(Dibs dibs) {
		dibsDao.deleteDibs(dibs);
	}

}
