package com.ssafy.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.BoardDao;
import com.ssafy.ssafit.model.dto.Board;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDao boardDao;
	
	@Override
	public List<Board> getBoard() {
		return boardDao.boardList();
	}

	@Override
	public void insertBoard(Board board) {
		boardDao.insertBoard(board);
	}

	@Override
	public void modifyBoard(Board board) {
		boardDao.updateBoard(board);
	}

	@Override
	public void deleteBoard(String id) {
		boardDao.deleteBoard(id);
	}

	@Override
	public Board getBoardById(String id) {
		return boardDao.selectBoard(id);
	}

}
