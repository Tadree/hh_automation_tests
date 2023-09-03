package ru.jiehk.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
public class EmployersSearchResponse {
    private int found, pages, page;
    @JsonProperty("per_page")
    private int perPage;
    private ArrayList<EmployersData> items = new ArrayList<>();

    @Data
    public static class EmployersData {
        private int id;
        private String name, url;
        @JsonProperty("alternate_url")
        private String alternateUrl;
        @JsonProperty("vacancies_url")
        private String vacanciesUrl;
        @JsonProperty("open_vacancies")
        private String openVacancies;
        @JsonProperty("logo_urls")
        private EmployersLogoUrlsData logoUrls;
    }

    @Data
    public static class EmployersLogoUrlsData {
        private String original;
        @JsonProperty("240")
        private String size240;
        @JsonProperty("90")
        private String size90;
    }
}