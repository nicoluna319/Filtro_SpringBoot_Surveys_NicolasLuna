package riwi.demo.infrastructure.abstract_services;

import riwi.demo.api.dto.request.UserReq;
import riwi.demo.api.dto.response.UserResp;

public interface IUserService extends CrudService<UserReq,UserResp, String>{
    
    public String FIELD_BY_SORT = "name";
}
