package edu.anudip.quizServices.redirect;

import edu.anudip.quizServices.payload.QuestionWrapper;
import edu.anudip.quizServices.payload.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTION-SERVICES")
public interface RequestToQuesService {

    @GetMapping("question/randomQuestionIds")
    public ResponseEntity<List<Integer>> getQuesForQuiz(@RequestParam String category, @RequestParam Integer noOfQues);

    @PostMapping("question/listQuizQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuesFromIds(@RequestBody List<Integer> quesIds);

    @PostMapping("question/score")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);
}
