package com.ssafy.ssafit.model.service;

import java.util.List;

import com.ssafy.ssafit.model.dto.Todo;

public interface TodoService {
	List<Todo> getAction(String id);
}
