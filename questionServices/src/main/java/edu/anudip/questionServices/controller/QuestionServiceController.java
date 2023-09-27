package edu.anudip.questionServices.controller;

import edu.anudip.questionServices.entity.Question;
import edu.anudip.questionServices.payload.QuestionWrapper;
import edu.anudip.questionServices.payload.Response;
import edu.anudip.questionServices.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionServiceController {

    @Autowired
    QuestionService quesServe;



    @GetMapping("listAllQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return quesServe.getAllQuestions();
    }


    @GetMapping("listByCategory/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable("category") String category){
        return quesServe.getQuestionsByCategory(category);
    }



    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return quesServe.addQuestion(question);
    }




    @GetMapping("randomQuestionIds")
    public ResponseEntity<List<Integer>> getQuestionForQuiz(@RequestParam String category, @RequestParam Integer noOfQues){
        return quesServe.getQuestionsForQuiz(category,noOfQues);
    }



    @PostMapping("listQuizQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromIds(@RequestBody List<Integer> quesIds){
        return quesServe.getQuestionsFromId(quesIds);
    }





    @PostMapping("score")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
        return quesServe.getScore(responses);
    }
}
