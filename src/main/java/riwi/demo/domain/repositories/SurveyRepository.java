package riwi.demo.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import riwi.demo.domain.entities.SurveyEntity;

@Repository
public interface SurveyRepository extends JpaRepository<SurveyEntity, String> {
    
}
