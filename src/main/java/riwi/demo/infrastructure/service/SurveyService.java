package riwi.demo.infrastructure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import riwi.demo.api.dto.request.SurveyReq;
import riwi.demo.api.dto.response.SurveyResp;

import riwi.demo.domain.entities.SurveyEntity;
import riwi.demo.domain.repositories.SurveyRepository;
import riwi.demo.infrastructure.abstract_services.ISurveyService;
import riwi.demo.utils.exception.BadRequestException;
import riwi.demo.utils.messages.ErrorMessages;

@Service
@AllArgsConstructor
public class SurveyService implements ISurveyService {
    
    @Autowired
    private final SurveyRepository surveyRepository;

    @Override
    public SurveyResp create(SurveyReq request) {


        SurveyEntity survey = this.requestToEntity(request);
        return this.entityToResponse(this.surveyRepository.save(survey));
    }

    @Override
    public SurveyResp get(String id) {

        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public SurveyResp update(SurveyReq request, String id) {

        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String id) {

        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Page<SurveyResp> getAll(int Page, int size) {

        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }


        private SurveyEntity find(String id) {
        return this.surveyRepository.findById(id)
                .orElseThrow(()-> new BadRequestException(ErrorMessages.idNotFound("Surveys")));
    }




        private SurveyEntity requestToEntity(SurveyReq survey) {
        return SurveyEntity.builder()
                .title(survey.getTitle())
                .description(survey.getDescription())         
                .creationDate(survey.getCreationDate())   
                .active(survey.getActive())  
                .build();
}

private SurveyResp entityToResponse(SurveyEntity entity) {
    return SurveyResp.builder()
            .title(entity.getId())
            .description(entity.getDescription())
            .creationDate(entity.getCreationDate())
            .active(entity.getActive())
            .build();

}
}
