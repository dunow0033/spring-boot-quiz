package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

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
}
