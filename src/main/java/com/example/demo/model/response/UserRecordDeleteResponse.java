package com.example.demo.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRecordDeleteResponse {

    @JsonProperty("UserRecord")
    private UserRecordBaseDeleteResponse userRecordBaseDeleteResponse;

}
