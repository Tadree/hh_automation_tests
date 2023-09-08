package ru.jiehk.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ru.jiehk.ui.helpers.Attach;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class MainPage {

    private final SelenideElement
            searchBar = $("[data-qa=search-input]"),
            searchButton = $("[data-qa=search-button]"),
            advancedSearchButton = $("[data-qa=advanced-search]"),
            searchSuggests = $(".suggest"),
            regionPopup = $("[data-qa=region-clarification]"),
            title = $("[data-qa=bloko-header-3]"),
            localeSwitcher = $("[data-qa=change-locale-EN]");

    @Step("Открываем главную страницу")
    public MainPage openMainPage() {
        open("");
        return this;
    }

    @Step("Проверка отображения строки поиска")
    public void searchBarDisplayingCheck() {
        searchBar.shouldBe(Condition.visible);
    }

    @Step("Проверка плейсхолдера строки поиска")
    public void searchBarPlaceHolderCheck(String expectedPlaceholder) {
        String actualPlaceholder = searchBar.getAttribute("placeholder");
        assertThat(actualPlaceholder).isEqualTo(expectedPlaceholder);
    }

    @Step("Вводим поисковой запрос в строку поиска")
    public MainPage searchBarSetValue(String searchRequest) {
        searchBar.setValue(searchRequest);
        return this;
    }

    @Step("Нажимаем на кнопку поиска")
    public void searchButtonClick() {
        searchButton.click();
    }

    @Step("Нажимаем на кнопку расширенного поиска")
    public void advancedSearchButtonClick() {
        advancedSearchButton.click();
    }

    @Step("Проверка появления релевантных поисковых подсказок")
    public void searchSuggestsCheck(String searchRequest) {
        searchSuggests.should(appear);
        searchSuggests.$("div").shouldHave(text(searchRequest));
    }

    @Step("Проверка появления popup подтверждения региона")
    public void regionPopupCheck() {
        regionPopup.shouldBe(appear);
        regionPopup.shouldHave(text("Ваш регион"));
    }

    @Step("Проверка заголовка на главной странице")
    public void titleCheck(String expectedTitle) {
        title.shouldHave(text(expectedTitle));
    }

    @Step("Проверка отсутствия ошибок в консоле на главной странице")
    public void consoleErrorsCheck() {
        String consoleLogs = Attach.getConsoleLogs();
        String errorText = "SEVERE";
        assertThat(consoleLogs).doesNotContain(errorText);
    }

    @Step("Переключаем язык")
    public MainPage changeLocale() {
        localeSwitcher.scrollTo();
        localeSwitcher.click();
        return this;
    }
}


