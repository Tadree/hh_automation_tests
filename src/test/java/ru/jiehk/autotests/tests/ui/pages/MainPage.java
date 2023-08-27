package ru.jiehk.autotests.tests.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ru.jiehk.autotests.tests.ui.helpers.Attach;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class MainPage {
    private SelenideElement
            searchBar = $("[data-qa=search-input]"),
            searchButton = $("[data-qa=search-button]"),
            advancedSearchButton = $("[data-qa=advanced-search]"),
            searchSuggests = $(".suggest"),
            regionPopup = $("[data-qa=region-clarification]"),
            searchBarTitle = $("[data-qa=bloko-header-3]");

    @Step("Открываем главную страницу")
    public MainPage openMainPage() {
        open("https://hh.ru/");
        return this;
    }

    @Step("Проверяем отображение строки поиска")

    public MainPage searchBarDisplayingCheck() {
        searchBar.shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверяем плейсхолдер строки поиска")
    public MainPage searchBarPlaceHolderCheck(String expectedPlaceholder) {
        String actualPlaceholder = searchBar.getAttribute("placeholder");
        assertThat(actualPlaceholder).isEqualTo(expectedPlaceholder);
        return this;
    }

    @Step("Вводим поисковой запрос в строку поиска")
    public MainPage searchBarSetValue(String searchRequest) {
        searchBar.setValue(searchRequest);
        return this;
    }

    @Step("Нажимаем на кнопку поиска")
    public MainPage searchButtonClick() {
        searchButton.click();
        return this;
    }

    @Step("Нажимаем на кнопку расширенного поиска")
    public MainPage advancedSearchButtonClick() {
        advancedSearchButton.click();
        return this;
    }

    @Step("Проверка появления релевантных поисковых подсказок")
    public MainPage searchSuggestsCheck(String searchRequest) {
        searchSuggests.should(appear);
        searchSuggests.$("div").shouldHave(text(searchRequest));
        return this;
    }

    @Step("Проверка появления popup подтверждения региона")
    public MainPage regionPopupCheck() {
        regionPopup.shouldBe(appear);
        regionPopup.shouldHave(text("Ваш регион"));
        return this;
    }

    @Step("Проверка заголовка строки поиска")
    public MainPage searchBarTitleCheck(String expectedTitle) {
        searchBarTitle.shouldHave(text(expectedTitle));
        return this;
    }

    @Step("Проверка отсутствия ошибок в консоле")
    public MainPage consoleErrorsCheck() {
        String consoleLogs = Attach.getConsoleLogs();
        String errorText = "SEVERE";
        assertThat(consoleLogs).doesNotContain(errorText);
        return this;
    }
}


