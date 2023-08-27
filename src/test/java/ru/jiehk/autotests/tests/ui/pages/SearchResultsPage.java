package ru.jiehk.autotests.tests.ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SearchResultsPage {
    private SelenideElement
            vacanciesSearchHeader = $("[data-qa=vacancies-search-header]"),
            vacancyResults = $("[data-qa=vacancy-serp__results]");


    @Step("Проверяем открытие страницы результатов поиска")
    public SearchResultsPage openSearchResultsPageCheck(String searchRequest) {
        vacanciesSearchHeader.shouldHave(text(("«" + searchRequest + "»")));
        vacancyResults.shouldBe(visible);
        return this;
    }
}
