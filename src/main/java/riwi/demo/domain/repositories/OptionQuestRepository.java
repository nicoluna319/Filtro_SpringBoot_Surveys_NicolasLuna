package riwi.demo.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import riwi.demo.domain.entities.OptionQuestionEntity;

@Repository
public interface OptionQuestRepository extends JpaRepository <OptionQuestionEntity, String> {
    
}