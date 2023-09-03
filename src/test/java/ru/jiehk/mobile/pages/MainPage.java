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
    public MainPage checkHeader(String title) {
        $(id("ru.hh.android:id/cell_section_header_large_narrow_text_view")).shouldHave(text(title));
        return this;
    }

    @Step("Вводим поисковый запрос")
    public MainPage searchBarSetValue(String searchRequest) {
        $(id("ru.hh.android:id/view_main_search_container")).click();
        $(id("ru.hh.android:id/toolbar_search_query")).sendKeys(searchRequest);
//        Keys.chord(Keys.ENTER);
        return this;
    }

    @Step("Проверка отображения поисковых подсказок")
    public MainPage searchSuggestsCheck(String searchRequest) {
        $$(AppiumBy.id("ru.hh.android:id/cell_compound_container"))
                .shouldHave(sizeGreaterThan(0));
        String suggestText = $(id("ru.hh.android:id/cell_compound_container")).text().replace("\n", "");
        suggestText.equals(text(searchRequest));
        return this;
    }
}
//ru.hh.android:id/view_main_search_image_button_back
//
//        ru.hh.android:id/cell_vacancy_card_button_response

//ru.hh.android:id/view_main_search_container
//
//        ru.hh.android:id/cell_serp_header_text_view_title
//        ru.hh.android:id/cell_vacancy_card_container


//            ru.hh.android:id/cell_compound_container - подсказкии