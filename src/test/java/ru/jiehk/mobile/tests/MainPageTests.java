package ru.jiehk.mobile.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.jiehk.mobile.pages.MainPage;

@Owner("Elena Kosiakova")
@Tag("android")
@Epic("Android tests")
@Feature("Main screen")
public class MainPageTests extends TestBase {

    private static final String TITLE = "Вакансии для вас";
    private static final String SEARCHREQUEST = "qa";

    private final MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Проверка заголовка главного экрана")
    void titleTest() {
        mainPage
                .closeAuthorizationScreen()
                .checkHeader(TITLE);
    }

    @Test
    @DisplayName("Проверка отображения релевантных поисковых подсказок")
    void displayingRelevantSuggestsTest() {
        mainPage
                .closeAuthorizationScreen()
                .searchBarSetValue(SEARCHREQUEST)
                .searchSuggestsCheck(SEARCHREQUEST);
    }
}
