package riwi.demo.infrastructure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import riwi.demo.api.dto.request.QuestionReq;

import riwi.demo.api.dto.response.QuestionResp;

import riwi.demo.domain.entities.QuestionEntity;

import riwi.demo.domain.repositories.QuestionRepository;
import riwi.demo.infrastructure.abstract_services.IQuestionService;
import riwi.demo.utils.exception.BadRequestException;
import riwi.demo.utils.messages.ErrorMessages;

@Service
@AllArgsConstructor
public class QuestionService implements IQuestionService {
    
    @Autowired
    private final QuestionRepository questionRepository;

    @Override
    public QuestionResp create(QuestionReq request) {

        QuestionEntity question = this.requestToEntity(request);
        return this.entityToResponse(this.questionRepository.save(question));
    }

    @Override
    public QuestionResp get(String id) {

        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public QuestionResp update(QuestionReq request, String id) {

        QuestionEntity question = this.find(id);
        QuestionEntity questionUpdate = this.requestToEntity(request);
        questionUpdate.setId(id);
        questionUpdate.setType(question.getType());
        return this.entityToResponse(this.questionRepository.save(questionUpdate));
    }

    @Override
    public void delete(String id) {

        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Page<QuestionResp> getAll(int Page, int size) {

        if (Page < 0)
            Page = 0;

        PageRequest pagination = PageRequest.of(Page, size);

        return this.questionRepository.findAll(pagination)
                .map(user -> this.entityToResponse(user));
    }


    private QuestionEntity find(String id) {
        return this.questionRepository.findById(id)
                .orElseThrow(()-> new BadRequestException(ErrorMessages.idNotFound("Question")));
    }


    private QuestionEntity requestToEntity(QuestionReq question) {
        return QuestionEntity.builder()
                .text(question.getText())
                .type(question.getType())         
                .active(question.getActive())   
                .build();
}

private QuestionResp entityToResponse(QuestionEntity entity) {
    return QuestionResp.builder()
            .id(entity.getId())
            .text(entity.getText())
            .type(entity.getType())
            .active(entity.getActive())
            .build();

}

    
}
