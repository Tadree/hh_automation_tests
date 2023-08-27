package ru.jiehk.autotests.tests.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PhoneConfirmErrorResponse {
    @JsonProperty("request_id")
    private String requestId;
    private ArrayList<ErrorData> errors = new ArrayList<>();

    @Data
    public static class ErrorData {
        private String type;
    }
}
