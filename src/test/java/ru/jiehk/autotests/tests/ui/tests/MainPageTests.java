package ru.jiehk.autotests.tests.ui.tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.jiehk.autotests.tests.ui.pages.AdvancedSearchPage;
import ru.jiehk.autotests.tests.ui.pages.MainPage;
import ru.jiehk.autotests.tests.ui.pages.SearchResultsPage;

public class MainPageTests extends TestBase {

    public static final String SEARCHPLACEHOLDER = "Профессия, должность или компания";
    public static final String SEARCHREQUEST = "qa";
    public static final String SEARCHTITLE = "Работа найдётся для каждого";
    public static final String ADVANCEDSEARCHPAGETITLE = "Поиск вакансий";
    MainPage mainPage = new MainPage();
    AdvancedSearchPage advancedSearchPage = new AdvancedSearchPage();
    SearchResultsPage searchResultsPage = new SearchResultsPage();

    @Test
    @Tag("ui")
    @DisplayName("Отображение строки поиска на главной странице")
    void searchBarTest() {
        mainPage
                .openMainPage()
                .searchBarDisplayingCheck();
    }

    @Test
    @Tag("ui")
    @DisplayName("Проверка плейсхолдера строки поиска на главной странице")
    void searchBarPlaceholderTest() {
        mainPage
                .openMainPage()
                .searchBarPlaceHolderCheck(SEARCHPLACEHOLDER);
    }

    @Test
    @Tag("ui")
    @DisplayName("Переход на страницу результатов поиска при выполнении поиска с главной страницы")
    void searchTest() {
        mainPage
                .openMainPage()
                .searchBarSetValue(SEARCHREQUEST)
                .searchButtonClick();
        searchResultsPage.openSearchResultsPageCheck(SEARCHREQUEST);
    }

    @Test
    @Tag("ui")
    @DisplayName("Переход на страницу расширенного поиска с главной страницы")
    void advancedSearchTest() {
        mainPage
                .openMainPage()
                .advancedSearchButtonClick();
        advancedSearchPage.openSearchResultsPageCheck(ADVANCEDSEARCHPAGETITLE);
    }

    @Test
    @Tag("ui")
    @DisplayName("Отображение поисковых подсказок на главной странице")
    void suggestsTest() {
        mainPage
                .openMainPage()
                .searchBarSetValue(SEARCHREQUEST)
                .searchSuggestsCheck(SEARCHREQUEST);
    }

    @Test
    @Tag("ui")
    @DisplayName("Проверка заголовка строки поиска на главной странице")
    void searchBarTitleTest() {
        mainPage
                .openMainPage()
                .searchBarTitleCheck(SEARCHTITLE);
    }

    @Test
    @Tag("ui")
    @DisplayName("Отображение popup подтверждения региона на главной странице")
    void regionPopupTest() {
        mainPage
                .openMainPage()
                .regionPopupCheck();
    }

    @Test
    @Tag("ui")
    @Disabled
    @DisplayName("Отсутствие ошибок в логах консоли")
    void consoleShouldNotHaveErrorsTest() {
        mainPage
                .openMainPage()
                .consoleErrorsCheck();
    }
}