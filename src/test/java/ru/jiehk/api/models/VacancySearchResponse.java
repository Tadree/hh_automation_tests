package ru.jiehk.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class VacancySearchResponse {
    private ArrayList<VacancyData> items = new ArrayList<>();

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class VacancyData {
        private String id;
    }
}