package edu.anudip.quizServices.serviceImplementation;

import edu.anudip.quizServices.entity.Quiz;
import edu.anudip.quizServices.payload.QuestionWrapper;
import edu.anudip.quizServices.payload.Response;
import edu.anudip.quizServices.redirect.RequestToQuesService;
import edu.anudip.quizServices.repository.QuizDao;
import edu.anudip.quizServices.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class QuizServiceImplementation implements QuizService {


    @Autowired
    RequestToQuesService requestToQuesService;

    @Autowired
    QuizDao quizDao;




    // this will store the random questionIds into a table with quiz title and quiz id
    @Override
    public ResponseEntity<String> createQuiz(String category, Integer noOfQues, String title) {

        // getbody method fetch the body from the response entity object
        List<Integer> questionIds = requestToQuesService.getQuesForQuiz(category,noOfQues).getBody();

        Quiz quiz = Quiz.builder().title(title).questionIds(questionIds).build();

        quizDao.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }





    // method to get the question for the quiz by providing the id
    // as this will be passing for attempting the quiz so we get the wrapper rather than question object
    // as question wrapper just contanins question title and options
    @Override
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer quizId) {
        Quiz quiz = quizDao.findById(quizId).get(); // fetching the quiz from the database

        List<Integer> quesIds = quiz.getQuestionIds(); // extracting questIds from quiz object

        // requesting the list of questionWrappers from the question microservice based on the question ids
        ResponseEntity<List<QuestionWrapper>> questions = requestToQuesService.getQuesFromIds(quesIds);

        return questions;

    }





    // calculating the result of the quiz attempted
    @Override
    public ResponseEntity<Integer> getScore(List<Response> responses) {
        return requestToQuesService.getScore(responses);
    }




}
