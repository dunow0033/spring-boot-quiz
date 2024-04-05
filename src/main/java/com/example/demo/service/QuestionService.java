package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.service.*;
import com.example.demo.dao.QuestionRepository;
import com.example.demo.model.Question;

@Service
public class QuestionService {
	
	@Autowired
	QuestionRepository questionRepo;
	
	public ResponseEntity<List<Question>> getAllQuestions() {
		try {
			return new ResponseEntity<>(questionRepo.findAll(), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
		try {
			return new ResponseEntity<>(questionRepo.findByCategory(category), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<String> addQuestion(Question question) {
		try {
			questionRepo.save(question);
			return new ResponseEntity<>("Success", HttpStatus.CREATED);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Fail", HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	public ResponseEntity<String> deleteQuestion(Integer id) {
		try {
				questionRepo.deleteById(id);
				return new ResponseEntity<>("Success", HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Failed to delete", HttpStatus.NOT_FOUND);
	}
}
