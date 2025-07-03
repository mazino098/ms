package com.example.demo.controller;

import com.example.demo.model.request.UserRecordRequest;
import com.example.demo.model.response.UserRecordDeleteResponse;
import com.example.demo.model.response.UserRecordWrapperResponse;
import com.example.demo.service.impl.UserRecordServiceImpl;
import com.example.demo.model.response.UserRecordResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRecordController {

    private final UserRecordServiceImpl userRecordService;

    public UserRecordController(UserRecordServiceImpl userRecordService) {
        this.userRecordService = userRecordService;
    }


    @PostMapping("/Create")
    public UserRecordResponse createUserRecord(@RequestBody UserRecordRequest request){

        return userRecordService.createUserRecord(request);
    }

    @GetMapping("/Retrieve")
    public UserRecordWrapperResponse getAllUserRecord(){
        return userRecordService.getAllUserRecord();
    }

    @PutMapping("/Update")
    public UserRecordResponse updateUserRecord(
            @RequestBody UserRecordRequest request
    ){
        return userRecordService.updateUserRecord(request);
    }

    @DeleteMapping("/Delete")
    public UserRecordDeleteResponse deleteUserRecord(@RequestParam Long id){
        return userRecordService.deleteUserRecord(id);
    }


}
