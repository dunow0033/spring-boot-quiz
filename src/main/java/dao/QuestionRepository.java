package dao;

import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer>{
	
	public List<Question> findByCategory(String category);
	
	@Query(value = "SELECT * FROM question q WHERE q.category=:category ORDER by RAND() LIMIT :numQ", nativeQuery = true)
	public List<Question>
}
