package ru.jiehk.autotests.tests.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class VacancySearchSuggestsErrorResponse {

    private String description;
    @JsonProperty("request_id")
    private String requestId;
}


