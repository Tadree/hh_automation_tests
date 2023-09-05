package ru.jiehk.mobile.pages;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.id;

public class MainPage {

    @Step("Закрываем экран авторизации")
    public MainPage closeAuthorizationScreen() {
        $(id("ru.hh.android:id/fragment_intentions_onboarding_choose_direction_image_close")).click();
        return this;
    }

    @Step("Проверка заголовка на главной странице")
    public void checkHeader(String title) {
        $(id("ru.hh.android:id/cell_section_header_large_narrow_text_view")).shouldHave(text(title));
    }

    @Step("Вводим поисковый запрос")
    public MainPage searchBarSetValue(String searchRequest) {
        $(id("ru.hh.android:id/view_main_search_container")).click();
        $(id("ru.hh.android:id/toolbar_search_query")).sendKeys(searchRequest);
        return this;
    }

    @Step("Проверка отображения поисковых подсказок")
    public void searchSuggestsCheck(String searchRequest) {
        $$(AppiumBy.id("ru.hh.android:id/cell_compound_container"))
                .shouldHave(sizeGreaterThan(0));
        String suggestText = $(id("ru.hh.android:id/cell_compound_container")).text().replace("\n", "");
        suggestText.equals(text(searchRequest));
    }
}