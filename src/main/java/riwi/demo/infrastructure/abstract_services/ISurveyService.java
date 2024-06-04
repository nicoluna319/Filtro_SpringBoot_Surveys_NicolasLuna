package riwi.demo.infrastructure.abstract_services;

import riwi.demo.api.dto.request.SurveyReq;
import riwi.demo.api.dto.response.SurveyResp;

public interface ISurveyService extends CrudService<SurveyReq, SurveyResp, String> {
    
    public String FIELD_BY_SORT = "title";
}
