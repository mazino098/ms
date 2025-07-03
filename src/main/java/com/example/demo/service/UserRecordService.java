package com.example.demo.service;

import com.example.demo.model.request.UserRecordRequest;
import com.example.demo.model.response.UserRecordBaseResponse;
import com.example.demo.model.response.UserRecordDeleteResponse;
import com.example.demo.model.response.UserRecordResponse;
import com.example.demo.model.response.UserRecordWrapperResponse;

import java.util.List;

public interface UserRecordService {

    UserRecordWrapperResponse getAllUserRecord();

    UserRecordResponse createUserRecord(UserRecordRequest userRecordBaseRequest);

    UserRecordResponse updateUserRecord(UserRecordRequest userRecordRequest);

    UserRecordDeleteResponse deleteUserRecord(Long id);
}
