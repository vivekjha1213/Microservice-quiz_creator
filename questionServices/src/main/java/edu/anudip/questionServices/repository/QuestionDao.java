package edu.anudip.questionServices.repository;

import edu.anudip.questionServices.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    // custom method
    List<Question> findByCategory(String category);

    // :<var> should match to the argument <var> passed in method
    // :<var1> should match to the @Param("<var1>")
    @Query(value = "select id from question where category=:category order by rand() limit :numQ", nativeQuery = true)
    List<Integer> findRandomQuestionsByCategory(String category,int numQ);
}