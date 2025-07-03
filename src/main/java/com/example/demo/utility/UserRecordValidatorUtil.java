package com.example.demo.utility;

import com.example.demo.model.error.ValidationException;
import com.example.demo.model.request.UserRecordRequest;

public class UserRecordValidatorUtil {

    public static final int MAX_LENGTH = 10;

    public static void validate(UserRecordRequest request){

        if(request.getDetails().getFirstName().length() > MAX_LENGTH){
            throw new ValidationException("Max length exceeded");
        }

    }



}