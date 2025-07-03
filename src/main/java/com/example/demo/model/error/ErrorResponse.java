package com.example.demo.model.error;

import com.example.demo.model.request.UserRecordBaseRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse {

    @JsonProperty("Error")
    private ErrorBaseResponse errorBaseResponse;

}
