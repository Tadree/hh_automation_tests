package ru.jiehk.autotests.tests.api.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.jiehk.autotests.tests.api.models.VacancySearchSuggestsErrorResponse;
import ru.jiehk.autotests.tests.api.models.VacancySearchSuggestsSuccessResponse;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static ru.jiehk.autotests.tests.api.helpers.specs.RequestSpec.requestSpec;
import static ru.jiehk.autotests.tests.api.helpers.specs.ResponseSpec.badRequestErrorResponseSpec;
import static ru.jiehk.autotests.tests.api.helpers.specs.ResponseSpec.successResponseSpec;

public class VacancySearchSuggestsTests extends TestBase {

    @ParameterizedTest(name = "Проверка получения поисковых подсказок на запрос {0}")
    @ValueSource(strings = {"тестировщик", "qa"})
    @Tag("api")
    @DisplayName("Проверка получения поисковых подсказок")
    void vacancySearchSuggestsTest(String searchQuery) {
        VacancySearchSuggestsSuccessResponse response = step("Выполнение запроса на получение поисковых подсказок", () ->
                given()
                        .spec(requestSpec)
                        .param("text", searchQuery)
                        .when()
                        .get("/suggests/vacancy_search_keyword")
                        .then()
                        .spec(successResponseSpec)
                        .extract().as(VacancySearchSuggestsSuccessResponse.class));

        step("Проверка ответа", () ->
                assertThat(response.getItems().get(0).getText()).containsIgnoringCase(searchQuery));
    }

    @Test
    @Tag("api")
    @DisplayName("Проверка ошибки получения поисковых подсказок при отсутствии текста для поиска ключевого слова")
    void vacancySearchSuggestsWithoutParamTextTest() {
        VacancySearchSuggestsErrorResponse response = step("Выполнение запроса на получение поисковых подсказок", () ->
                given()
                        .spec(requestSpec)
                        .when()
                        .get("/suggests/vacancy_search_keyword")
                        .then()
                        .spec(badRequestErrorResponseSpec)
                        .extract().as(VacancySearchSuggestsErrorResponse.class));

        step("Проверка ответа", () -> {
            assertEquals("bad argument", response.getDescription());
            assertNotNull(response.getRequestId());
        });
    }
}
