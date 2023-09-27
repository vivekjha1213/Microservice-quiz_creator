package edu.anudip.quizServices.controller;

import edu.anudip.quizServices.payload.QuestionWrapper;
import edu.anudip.quizServices.payload.QuizDTO;
import edu.anudip.quizServices.payload.Response;
import edu.anudip.quizServices.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {


    @Autowired
    QuizService quizService;





    @PostMapping("createQuiz")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDTO quizDTO){
        return quizService.createQuiz(quizDTO.getCategory(),quizDTO.getNoOfQues(),quizDTO.getTitle());
    }



    @GetMapping("getQuiz/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable Integer id){
        return quizService.getQuizQuestions(id);
    }



    @PostMapping("score")
    public ResponseEntity<Integer> result(@RequestBody List<Response> responses){
        return quizService.getScore(responses);
    }


}
