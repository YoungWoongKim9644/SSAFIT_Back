package com.ssafy.ssafit.model.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.Todo;
import com.ssafy.ssafit.model.service.TodoService;

@RestController
@RequestMapping("/todo")
@CrossOrigin("*")
public class TodoController {
	
	@Autowired
	TodoService todoService;
	
	@PostMapping("/list/{id}")
	public ResponseEntity<List<Todo>> list(@PathVariable String id) {
		return new ResponseEntity<List<Todo>>(todoService.getAction(id),
					HttpStatus.OK);
	}
}
