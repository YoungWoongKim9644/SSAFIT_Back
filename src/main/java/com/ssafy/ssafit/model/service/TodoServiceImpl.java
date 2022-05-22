package com.ssafy.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.TodoDao;
import com.ssafy.ssafit.model.dto.Todo;

@Service("todoService")
public class TodoServiceImpl implements TodoService {
	
	@Autowired
	TodoDao todoDao;

	@Override
	public List<Todo> getAction(String id) {
		return todoDao.todoList(id);
	}
	
	
}
