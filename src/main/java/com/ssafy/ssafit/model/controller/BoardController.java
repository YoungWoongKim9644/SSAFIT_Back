package com.ssafy.ssafit.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.Board;
import com.ssafy.ssafit.model.service.BoardService;

@RequestMapping("/board")
@RestController
@CrossOrigin("*")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@GetMapping("/detail/{id}")
	public ResponseEntity<Board> detail(@PathVariable String id){
		return new ResponseEntity<Board>(boardService.getBoardById(id),
				HttpStatus.OK);
				
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Board>> list() {
		System.out.println("come");
		return new ResponseEntity<List<Board>>
		(boardService.getBoard(), HttpStatus.OK);
	}
	
	@PostMapping("/write")
	public void write(@RequestBody Board board) {
		boardService.insertBoard(board);
	}
	
	@PutMapping("/update/{id}")
	public void update(@RequestBody Board board) {
		boardService.modifyBoard(board);
	}
	
	@DeleteMapping("/delete")
	public void delete(String id) {
		boardService.deleteBoard(id);
	}
}
