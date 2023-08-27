package ru.jiehk.autotests.tests.ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class AdvancedSearchPage {
    private SelenideElement
            advancedSearchPageTitle = $("[data-qa=bloko-header-1]");

    @Step("Проверяем открытие страницы расширенного поиска")
    public AdvancedSearchPage openSearchResultsPageCheck(String advancedSearchExpectedTitle) {
        advancedSearchPageTitle.shouldHave(text(advancedSearchExpectedTitle));
        return this;
    }
}
