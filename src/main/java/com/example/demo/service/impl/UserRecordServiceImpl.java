package com.example.demo.service.impl;

import com.example.demo.model.UserRecord;
import com.example.demo.model.error.NotFoundException;
import com.example.demo.model.request.UserRecordRequest;
import com.example.demo.model.response.*;
import com.example.demo.repository.UserRecordRepository;
import com.example.demo.service.UserRecordService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserRecordServiceImpl implements UserRecordService {

    private final UserRecordRepository repository;

    public UserRecordServiceImpl(UserRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserRecordWrapperResponse getAllUserRecord() {
        List<UserRecord> listAll = repository.findAll();

        List<UserRecordBaseResponse> base = listAll.stream()
                .map(userRecord -> UserRecordBaseResponse.builder()
                        .id(userRecord.getId())
                        .firstName(userRecord.getFirstName())
                        .lastName(userRecord.getLastName())
                        .build()).toList();

        return UserRecordWrapperResponse.builder()
                .userRecordList(base)
                .build();
    }



    @Override
    public UserRecordResponse createUserRecord(UserRecordRequest userRecordRequest) {

        UserRecord user = new UserRecord();
        user.setFirstName(userRecordRequest.getDetails().getFirstName());
        user.setLastName(userRecordRequest.getDetails().getLastName());

        UserRecord saved = repository.save(user);

        UserRecordBaseResponse response = new UserRecordBaseResponse();
        response.setFirstName(saved.getFirstName());
        response.setLastName(saved.getLastName());


        return UserRecordResponse.builder()
                .userRecordBaseResponse(response)
                .build();
    }

    @Override
    @Transactional
    public UserRecordResponse updateUserRecord(UserRecordRequest userRecordRequest) {

        UserRecord userExist = repository.findById(userRecordRequest.getDetails().getId())
                .orElseThrow(() -> new NotFoundException("User record not found"));

        userExist.setFirstName(userRecordRequest.getDetails().getFirstName());
        userExist.setLastName(userRecordRequest.getDetails().getLastName());

        UserRecordBaseResponse base = UserRecordBaseResponse.builder()
                .id(userExist.getId())
                .firstName(userExist.getFirstName())
                .lastName(userExist.getLastName())
                .build();

        UserRecordResponse response =UserRecordResponse.builder()
                .userRecordBaseResponse(base)
                .build();

        return response;
    }


    @Override
    public UserRecordDeleteResponse deleteUserRecord(Long id){

        UserRecord userExisting = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("User does not existing"));

        repository.deleteById(id);

        UserRecordBaseDeleteResponse base = UserRecordBaseDeleteResponse.builder()
                        .message("UserRecord Does not exist").
                build();


        UserRecordDeleteResponse response = UserRecordDeleteResponse.builder()
                        .userRecordBaseDeleteResponse(base).
                build();

        return response;
    }


}