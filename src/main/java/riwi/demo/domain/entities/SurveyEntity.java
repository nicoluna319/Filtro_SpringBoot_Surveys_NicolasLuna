package riwi.demo.domain.entities;

import java.sql.Timestamp;
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

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "survey")
public class SurveyEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, length = 150)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Timestamp creationDate;

    @ManyToOne
    @JoinColumn(name = "creator_id", referencedColumnName = "id")
    private UserEntity creator;


    @Column(nullable = false)
    private Boolean active;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "survey", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
    private List<QuestionEntity> question;
    

}
