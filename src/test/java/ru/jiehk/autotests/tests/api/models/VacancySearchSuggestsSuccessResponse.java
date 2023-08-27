package ru.jiehk.autotests.tests.api.models;

import lombok.Data;

import java.util.ArrayList;

@Data
public class VacancySearchSuggestsSuccessResponse {

    private ArrayList<SuggestsData> items = new ArrayList<>();

    @Data
    public static class SuggestsData {
        private String text;
    }
}