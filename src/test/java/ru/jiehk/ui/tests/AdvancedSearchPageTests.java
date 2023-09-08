package ru.jiehk.ui.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.jiehk.ui.pages.AdvancedSearchPage;
import ru.jiehk.ui.pages.SearchResultsPage;

@Owner("Elena Kosiakova")
@Tag("ui")
@Epic("UI tests")
@Feature("Advanced search page")
public class AdvancedSearchPageTests extends TestBase {

    public static final String KEYWORDS = "специалист по тестированию";

    AdvancedSearchPage advancedSearchPage = new AdvancedSearchPage();
    SearchResultsPage searchResultsPage = new SearchResultsPage();

    @Test
    @DisplayName("Подстановка подсказки в поле \"Ключевые слова\" на странице расширенного поиска")
    void insertSuggestIntoKeywordsInputTest() {
        advancedSearchPage
                .openAdvancedSearchPage()
                .keywordsInputSuggestClick()
                .keywordsInputSuggestCheck();
    }

    @Test
    @DisplayName("Переход на страницу результатов поиска при выполнении поиска со страницы расширенного поиска")
    void redirectToSearchResultsPageTest() {
        advancedSearchPage
                .openAdvancedSearchPage()
                .keywordsInputSetValue(KEYWORDS)
                .searchButtonClick();
        searchResultsPage.openSearchResultsPageCheck(KEYWORDS);
    }
}
