package ru.jiehk.ui.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
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
@Epic("UI tests")
@Feature("Main page")
public class MainPageTests extends TestBase {

    private static final String SEARCHPLACEHOLDER = "Профессия, должность или компания";
    private static final String SEARCHREQUEST = "qa";
    private static final String TITLE = "Работа найдётся для каждого";
    private static final String TITLEEN = "There's a job for everyone";
    private static final String ADVANCEDSEARCHPAGETITLE = "Поиск вакансий";

    private final MainPage mainPage = new MainPage();
    private final AdvancedSearchPage advancedSearchPage = new AdvancedSearchPage();
    private final SearchResultsPage searchResultsPage = new SearchResultsPage();

    @Test
    @DisplayName("Отображение строки поиска на главной странице")
    void searchBarDisplayingTest() {
        mainPage
                .openMainPage()
                .searchBarDisplayingCheck();
    }

    @Test
    @DisplayName("Проверка плейсхолдера строки поиска на главной странице")
    void searchBarPlaceholderTextTest() {
        mainPage
                .openMainPage()
                .searchBarPlaceHolderCheck(SEARCHPLACEHOLDER);
    }

    @Test
    @DisplayName("Переход на страницу результатов поиска при выполнении поиска с главной страницы")
    void redirectToSearchResultsPageTest() {
        mainPage
                .openMainPage()
                .searchBarSetValue(SEARCHREQUEST)
                .searchButtonClick();
        searchResultsPage.
                openSearchResultsPageCheck(SEARCHREQUEST);
    }

    @Test
    @DisplayName("Переход на страницу расширенного поиска с главной страницы")
    void redirectToAdvancedSearchTest() {
        mainPage
                .openMainPage()
                .advancedSearchButtonClick();
        advancedSearchPage.
                openAdvancedSearchPageCheck(ADVANCEDSEARCHPAGETITLE);
    }

    @Test
    @DisplayName("Отображение поисковых подсказок на главной странице")
    void displayingRelevantSuggestsTest() {
        mainPage
                .openMainPage()
                .searchBarSetValue(SEARCHREQUEST)
                .searchSuggestsCheck(SEARCHREQUEST);
    }

    @Test
    @DisplayName("Проверка заголовка на главной странице")
    void titleTextTest() {
        mainPage
                .openMainPage()
                .titleCheck(TITLE);
    }

    @Test
    @DisplayName("Отображение popup подтверждения региона на главной странице")
    void displayingRegionPopupTest() {
        mainPage
                .openMainPage()
                .regionPopupCheck();
    }

    @Test
    @DisplayName("Проверка смены языка на английский")
    void languageSwitcherTest() {
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