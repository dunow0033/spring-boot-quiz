package dao;

import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository {
	
	public List<Question> findByCategory(String category);
	
	@Query()
}
