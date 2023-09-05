package ru.jiehk.mobile.tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.jiehk.mobile.pages.MainPage;
import ru.jiehk.mobile.pages.SearchResultsPage;

@Owner("Elena Kosiakova")
@Tag("android")
public class SearchTest extends TestBase {

    public static final String SEARCHREQUEST = "qa";

    MainPage mainPage = new MainPage();
    SearchResultsPage searchResultsPage = new SearchResultsPage();

    @Test
    @DisplayName("Проверка отображения результатов поиска")
    void searchTest() {
        mainPage
                .closeAuthorizationScreen()
                .searchBarSetValue(SEARCHREQUEST + "\\n");
        searchResultsPage.searchResultsCheck();
    }
}

