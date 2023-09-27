package edu.anudip.questionServices.serviceImplementation;

import edu.anudip.questionServices.entity.Question;
import edu.anudip.questionServices.payload.QuestionWrapper;
import edu.anudip.questionServices.payload.Response;
import edu.anudip.questionServices.repository.QuestionDao;
import edu.anudip.questionServices.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImplementation implements QuestionService {


    @Autowired
    QuestionDao questionDao;




    @Override
    public ResponseEntity<List<Question>> getAllQuestions() {
        try{

            // using findAll method of repository
            return new ResponseEntity<>(questionDao.findAll(),HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
        }

        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }




    @Override
    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try{

            // custom method of repository to fetch the question all by catergory
            return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
        }

        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }






    @Override
    public ResponseEntity<String> addQuestion(Question question) {

        // save method is use to insert the data or record into database
        questionDao.save(question);

        return new ResponseEntity<>("Successfully inserted new question",HttpStatus.OK);
    }





    @Override
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(String categoryName, Integer numQuestions) {

        return new ResponseEntity<>(questionDao.findRandomQuestionsByCategory(categoryName,numQuestions),HttpStatus.OK);

    }






    @Override
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> questionIds) {
        // creating two empty lists
        List<QuestionWrapper> questionWrappers = new ArrayList<>();
        List<Question> questions = new ArrayList<>();

        // fetching and putting the question from the database based on the ids provided in the parameters
        // inserting them into the list created above
        for(Integer id:questionIds){
            questions.add(questionDao.findById(id).get());
        }

        // Transfer the question to the user in the questionWrapper that only contains questions and options
        // logic
        // copying the content from the question object into questoionWrapper object and create the list of later object
        for(Question question:questions){

            // using builder method provided by lombok
            QuestionWrapper questionWrapper = QuestionWrapper.builder()
                    .id(question.getId())
                    .questionTitle(question.getQuestionTitle())
                    .option1(question.getOption1())
                    .option2(question.getOption2())
                    .option3(question.getOption3())
                    .option4(question.getOption4())
                    .build();

            questionWrappers.add(questionWrapper);
        }

        // returning the list of questionWrappers
        return new ResponseEntity<>(questionWrappers,HttpStatus.OK);
    }






    @Override
    public ResponseEntity<Integer> getScore(List<Response> responses) {
        int score = 0;

        // calculating score over passed list of responses and matching the answer given in
        // response with the correct answers present in the databases against the question id
        for(Response res:responses){

            // fetching question using id from the response object
            Question question = questionDao.findById(res.getId()).get();

            // matching the answer in the response object with the answer in the question object
            if(res.getResponse().equals(question.getCorrectAnswer())){
                score++;
            }

        }

        return new ResponseEntity<>(score,HttpStatus.OK);
    }






}
