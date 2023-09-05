package ru.jiehk.mobile.tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.jiehk.mobile.pages.MainPage;

@Owner("Elena Kosiakova")
@Tag("android")
public class MainPageTests extends TestBase {

    public static final String TITLE = "Вакансии для вас";
    public static final String SEARCHREQUEST = "qa";

    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Проверка заголовка главного экрана")
    void titleTest() {
        mainPage
                .closeAuthorizationScreen()
                .checkHeader(TITLE);
    }

    @Test
    @DisplayName("Проверка отображения релевантных поисковых подсказок")
    void suggestsTest() {
        mainPage
                .closeAuthorizationScreen()
                .searchBarSetValue(SEARCHREQUEST)
                .searchSuggestsCheck(SEARCHREQUEST);
    }
}
