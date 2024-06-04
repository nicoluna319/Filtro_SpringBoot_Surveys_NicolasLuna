package riwi.demo.infrastructure.abstract_services;

import riwi.demo.api.dto.request.QuestionReq;
import riwi.demo.api.dto.response.QuestionResp;

public interface IQuestionService extends CrudService<QuestionReq, QuestionResp, String> {

    public String FIELD_BY_SORT = "type";
    
}
