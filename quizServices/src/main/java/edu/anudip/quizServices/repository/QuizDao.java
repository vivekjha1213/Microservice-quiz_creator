package edu.anudip.quizServices.repository;

import edu.anudip.quizServices.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz,Integer> {
}
