package com.ssafy.ssafit.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.Dibs;
import com.ssafy.ssafit.model.service.DibsService;

@RequestMapping("/dibs")
@RestController
@CrossOrigin("*")
public class DibsController {
	
	@Autowired
	DibsService dibsService;
	
	@GetMapping("/list")
	public ResponseEntity<List<Dibs>> list(@RequestParam String id){
		System.out.println("here");
		System.out.println(id);
		return new ResponseEntity<List<Dibs>>(dibsService.getDibs(id), HttpStatus.OK);
	}
	
	@PostMapping("/insert")
	public void insert(@RequestBody Dibs dibs) {
		System.out.println(dibs.toString());
		dibsService.makeDibs(dibs);
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestBody Dibs dibs) {
		System.out.println(dibs.toString());
		dibsService.deleteDibs(dibs);
	}

}
