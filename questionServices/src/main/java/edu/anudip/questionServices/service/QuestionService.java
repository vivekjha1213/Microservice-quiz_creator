package edu.anudip.questionServices.service;

import edu.anudip.questionServices.entity.Question;
import edu.anudip.questionServices.payload.QuestionWrapper;
import edu.anudip.questionServices.payload.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuestionService {
    public ResponseEntity<List<Question>> getAllQuestions();

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category);

    public ResponseEntity<String> addQuestion(Question question);

    public ResponseEntity<List<Integer>> getQuestionsForQuiz(String categoryName, Integer numQuestions);

    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> questionIds);

    public ResponseEntity<Integer> getScore(List<Response> responses);
}