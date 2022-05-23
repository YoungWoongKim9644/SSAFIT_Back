package com.ssafy.ssafit.model.dao;

import java.util.List;

import com.ssafy.ssafit.model.dto.Todo;

public interface TodoDao {
	List<Todo> todoList(String id);
	void insertTodo(Todo todo);
	void updateTodo(String action);
	void deleteTodo(String action);
} 
