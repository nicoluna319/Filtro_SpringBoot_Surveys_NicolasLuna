package riwi.demo.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "optionQuestion")
public class OptionQuestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;


    @Column(nullable = false)
    private String text;


    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    private QuestionEntity question;

    @Column(nullable = false)
    private Boolean active;
}
