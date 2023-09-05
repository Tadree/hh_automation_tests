package ru.jiehk.ui.tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.jiehk.ui.pages.AdvancedSearchPage;
import ru.jiehk.ui.pages.MainPage;
import ru.jiehk.ui.pages.SearchResultsPage;

@Owner("Elena Kosiakova")
@Tag("ui")
public class MainPageTests extends TestBase {

    public static final String SEARCHPLACEHOLDER = "Профессия, должность или компания";
    public static final String SEARCHREQUEST = "qa";
    public static final String TITLE = "Работа найдётся для каждого";
    public static final String TITLEEN = "There's a job for everyone";
    public static final String ADVANCEDSEARCHPAGETITLE = "Поиск вакансий";

    MainPage mainPage = new MainPage();
    AdvancedSearchPage advancedSearchPage = new AdvancedSearchPage();
    SearchResultsPage searchResultsPage = new SearchResultsPage();

    @Test
    @DisplayName("Отображение строки поиска на главной странице")
    void searchBarTest() {
        mainPage
                .openMainPage()
                .searchBarDisplayingCheck();
    }

    @Test
    @DisplayName("Проверка плейсхолдера строки поиска на главной странице")
    void searchBarPlaceholderTest() {
        mainPage
                .openMainPage()
                .searchBarPlaceHolderCheck(SEARCHPLACEHOLDER);
    }

    @Test
    @DisplayName("Переход на страницу результатов поиска при выполнении поиска с главной страницы")
    void searchTest() {
        mainPage
                .openMainPage()
                .searchBarSetValue(SEARCHREQUEST)
                .searchButtonClick();
        searchResultsPage.
                openSearchResultsPageCheck(SEARCHREQUEST);
    }

    @Test
    @DisplayName("Переход на страницу расширенного поиска с главной страницы")
    void advancedSearchTest() {
        mainPage
                .openMainPage()
                .advancedSearchButtonClick();
        advancedSearchPage.
                openAdvancedSearchPageCheck(ADVANCEDSEARCHPAGETITLE);
    }

    @Test
    @DisplayName("Отображение поисковых подсказок на главной странице")
    void suggestsTest() {
        mainPage
                .openMainPage()
                .searchBarSetValue(SEARCHREQUEST)
                .searchSuggestsCheck(SEARCHREQUEST);
    }

    @Test
    @DisplayName("Проверка заголовка на главной странице")
    void titleTest() {
        mainPage
                .openMainPage()
                .titleCheck(TITLE);
    }

    @Test
    @DisplayName("Отображение popup подтверждения региона на главной странице")
    void regionPopupTest() {
        mainPage
                .openMainPage()
                .regionPopupCheck();
    }

    @Test
    @DisplayName("Проверка смены языка на английский")
    public void languageSwitcherTest() {
        mainPage
                .openMainPage()
                .changeLocale()
                .titleCheck(TITLEEN);
    }

    @Test
    @Disabled
    @DisplayName("Отсутствие ошибок в логах консоли")
    void consoleShouldNotHaveErrorsTest() {
        mainPage
                .openMainPage()
                .consoleErrorsCheck();
    }
}