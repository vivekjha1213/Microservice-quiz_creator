package edu.anudip.quizServices.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @ElementCollection // used with embedded types if it was user defined than @ManyToOne or others will be used
    private List<Integer> questionIds;
}
