package ru.jiehk.ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SearchResultsPage {

    private final SelenideElement
            vacanciesSearchHeader = $("[data-qa=vacancies-search-header]"),
            vacancyResults = $("[data-qa=vacancy-serp__results]");

    @Step("Проверка открытия страницы результатов поиска")
    public void openSearchResultsPageCheck(String searchRequest) {
        vacanciesSearchHeader.shouldHave(text(("«" + searchRequest + "»")));
        vacancyResults.shouldBe(visible);
    }
}
