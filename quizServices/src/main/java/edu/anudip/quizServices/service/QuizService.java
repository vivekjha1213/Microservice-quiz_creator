package edu.anudip.quizServices.service;

import edu.anudip.quizServices.payload.QuestionWrapper;
import edu.anudip.quizServices.payload.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuizService {
    public ResponseEntity<String> createQuiz(String category, Integer noOfQues, String title);

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer quizId);

    // calculating the result of the quiz attempted
    ResponseEntity<Integer> getScore(List<Response> responses);
}
