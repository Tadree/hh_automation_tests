package ru.jiehk.autotests.tests.ui.tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.jiehk.autotests.tests.ui.pages.AdvancedSearchPage;
import ru.jiehk.autotests.tests.ui.pages.SearchResultsPage;

@Owner("Elena Kosiakova")
@Tag("ui")
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
    void advancedSearchTest() {
        advancedSearchPage
                .openAdvancedSearchPage()
                .keywordsInputSetValue(KEYWORDS)
                .searchButtonClick();
        searchResultsPage.openSearchResultsPageCheck(KEYWORDS);
    }
}
