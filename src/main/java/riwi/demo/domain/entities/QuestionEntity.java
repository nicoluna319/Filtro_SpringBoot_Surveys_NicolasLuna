package riwi.demo.domain.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import riwi.demo.utils.enums.Type;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "question")
public class QuestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;


    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    private Type type;
    
    @ManyToOne
    @JoinColumn(name = "survey_id", referencedColumnName = "id")
    private SurveyEntity survey;    

    @Column(nullable = false)
    private Boolean active;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "question", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
    private List<OptionQuestionEntity> optionQuestion;


}
