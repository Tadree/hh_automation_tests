package ru.jiehk.mobile.pages;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultsPage {

    @Step("Проверка наличиия результатов поиска")
    public void searchResultsCheck() {
        $$(AppiumBy.id("ru.hh.android:id/cell_vacancy_card_container"))
                .shouldHave(sizeGreaterThan(0));
    }
}
