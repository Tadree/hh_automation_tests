package ru.jiehk.mobile.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.jiehk.mobile.pages.MainPage;
import ru.jiehk.mobile.pages.SearchResultsPage;

import static com.codeborne.selenide.Selenide.open;

@Owner("Elena Kosiakova")
@Tag("android")
@Epic("Android tests")
@Feature("Search screen")
public class SearchTest extends TestBase {

    private static final String SEARCHREQUEST = "qa";

    private final MainPage mainPage = new MainPage();
    private final SearchResultsPage searchResultsPage = new SearchResultsPage();

    @Test
    @DisplayName("Проверка отображения результатов поиска")
    void displayingSearchResultsTest() {
        open();
        mainPage
                .closeAuthorizationScreen()
                .searchBarSetValue(SEARCHREQUEST + "\\n");
        searchResultsPage.searchResultsCheck();
    }
}

