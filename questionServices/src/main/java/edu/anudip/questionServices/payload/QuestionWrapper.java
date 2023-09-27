package edu.anudip.questionServices.payload;

/*
this class is the trim down version of question class
it only contains questiontitle and options
*/

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionWrapper {

    private Integer id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

}
