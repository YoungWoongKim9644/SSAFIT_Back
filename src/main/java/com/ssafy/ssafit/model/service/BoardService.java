package com.ssafy.ssafit.model.service;

import java.util.List;

import com.ssafy.ssafit.model.dto.Board;

public interface BoardService {
	List<Board> getBoard();
	Board getBoardById(String id);
	void insertBoard(Board board);
	void modifyBoard(Board board);
	void deleteBoard(String id);
}
