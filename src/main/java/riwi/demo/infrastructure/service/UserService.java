package riwi.demo.infrastructure.service;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import riwi.demo.api.dto.request.UserReq;
import riwi.demo.api.dto.response.UserResp;
import riwi.demo.domain.entities.UserEntity;
import riwi.demo.domain.repositories.UserRepository;
import riwi.demo.infrastructure.abstract_services.IUserService;
import riwi.demo.utils.exception.BadRequestException;
import riwi.demo.utils.messages.ErrorMessages;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    @Autowired
    private final UserRepository userRepository;

    @Override
    public UserResp create(UserReq request) {

        UserEntity user = this.requestToEntity(request);
        return this.entityToResponse(this.userRepository.save(user));

    }

    @Override
    public UserResp get(String id) {

        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public UserResp update(UserReq request, String id) {

        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String id) {

        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Page<UserResp> getAll(int Page, int size) {

        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }
    

    private UserEntity find(String id) {
        return this.userRepository.findById(id)
                .orElseThrow(()-> new BadRequestException(ErrorMessages.idNotFound("User")));
    }



    private UserEntity requestToEntity(UserReq user) {
        return UserEntity.builder()
                .name(user.getName())
                .password(user.getPassword())
                .email(user.getEmail())              
                .active(user.getActive())
                .build();
}


private UserResp entityToResponse(UserEntity entity) {
    return UserResp.builder()
            .id(entity.getId())
            .name(entity.getName())
            .email(entity.getEmail())
            .active(entity.getActive())
            .build();

}
}
