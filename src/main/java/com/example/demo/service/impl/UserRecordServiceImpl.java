package com.example.demo.service.impl;

import com.example.demo.model.UserRecord;
import com.example.demo.model.request.UserRecordRequest;
import com.example.demo.model.response.UserRecordBaseResponse;
import com.example.demo.model.response.UserRecordResponse;
import com.example.demo.model.response.UserRecordWrapperResponse;
import com.example.demo.repository.UserRecordRepository;
import com.example.demo.service.UserRecordService;
import lombok.extern.slf4j.Slf4j;
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
    public UserRecordResponse updateUserRecord(UserRecordRequest userRecordRequest, Long id) {

        UserRecord userExist = repository.findById(id)
                .orElseThrow();


        return null;
    }


}