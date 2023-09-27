package edu.anudip.questionServices.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity // annotation use to consider class below it is the ORM model
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // primary key

    private String questionTitle; // question

    // four options
    private String option1;
    private String option2;
    private String option3;
    private String option4;

    private String correctAnswer;

    // describe the question belong to java or mysql
    private String category;

}