package com.ssafy.ssafit.model.dao;

import java.util.List;

import com.ssafy.ssafit.model.dto.Board;

public interface BoardDao {
	List<Board> boardList();
	Board selectBoard(String id);
	void insertBoard(Board board);
	void updateBoard(Board board);
	void deleteBoard(String id);
}
