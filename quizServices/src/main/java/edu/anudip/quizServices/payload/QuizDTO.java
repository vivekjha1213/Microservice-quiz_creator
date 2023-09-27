package edu.anudip.quizServices.payload;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


// this class is used to get the data from the presentation layer and pass it to service layer
public class QuizDTO {

    String category;
    String title;
    Integer noOfQues;

}
