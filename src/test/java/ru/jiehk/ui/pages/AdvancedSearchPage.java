package ru.jiehk.ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AdvancedSearchPage {

    private final SelenideElement
            title = $("[data-qa=bloko-header-1]"),
            keywordsInput = $("[data-qa=vacancysearch__keywords-input]"),
            keywordsInputSuggest = $(".bloko-form-hint button"),
            searchButton = $("[data-qa=advanced-search-submit-button]");

    @Step("Открываем страницу расширенного поиска")
    public AdvancedSearchPage openAdvancedSearchPage() {
        open("/search/vacancy/advanced");
        return this;
    }

    @Step("Нажимаем на подсказку поля \"Ключевые слова\"")
    public AdvancedSearchPage keywordsInputSuggestClick() {
        keywordsInputSuggest.click();
        return this;
    }

    @Step("Вводим запрос в поле \"Ключевые слова\"")
    public AdvancedSearchPage keywordsInputSetValue(String searchRequest) {
        keywordsInput.setValue(searchRequest);
        return this;
    }

    @Step("Нажимаем на кнопку поиска")
    public void searchButtonClick() {
        searchButton.click();
    }

    @Step("Проверка подстановки подсказки в поле \"Ключевые слова\"")
    public void keywordsInputSuggestCheck() {
        keywordsInput.shouldHave(value(keywordsInputSuggest.text()));
    }

    @Step("Проверка открытия страницы расширенного поиска")
    public void openAdvancedSearchPageCheck(String advancedSearchExpectedTitle) {
        title.shouldHave(text(advancedSearchExpectedTitle));
    }
}
