package ru.jiehk.api.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.jiehk.api.models.VacancySearchSuggestsErrorResponse;
import ru.jiehk.api.models.VacancySearchSuggestsSuccessResponse;
import ru.jiehk.api.specs.RequestSpec;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static ru.jiehk.api.specs.ResponseSpec.responseSpecCode400;
import static ru.jiehk.api.specs.ResponseSpec.responseSpecCode200;

@Owner("Elena Kosiakova")
@Tag("api")
@Epic("API tests")
@Feature("Suggests request")
public class VacancySearchSuggestsTests extends TestBase {

    @ParameterizedTest(name = "Проверка получения поисковых подсказок на запрос {0}")
    @ValueSource(strings = {"тестировщик", "qa"})
    @DisplayName("Проверка получения поисковых подсказок")
    void vacancySearchSuggestsTest(String searchQuery) {
        VacancySearchSuggestsSuccessResponse response = step("Выполнение запроса на получение поисковых подсказок", () ->
                given()
                        .spec(RequestSpec.requestSpec)
                        .param("text", searchQuery)
                        .when()
                        .get("/suggests/vacancy_search_keyword")
                        .then()
                        .spec(responseSpecCode200)
                        .extract().as(VacancySearchSuggestsSuccessResponse.class));

        step("Проверка ответа", () ->
                assertThat(response.getItems().get(0).getText()).containsIgnoringCase(searchQuery));
    }

    @Test
    @DisplayName("Проверка ошибки получения поисковых подсказок при отсутствии текста для поиска ключевого слова")
    void vacancySearchSuggestsWithoutParamTextTest() {
        VacancySearchSuggestsErrorResponse response = step("Выполнение запроса на получение поисковых подсказок", () ->
                given()
                        .spec(RequestSpec.requestSpec)
                        .when()
                        .get("/suggests/vacancy_search_keyword")
                        .then()
                        .spec(responseSpecCode400)
                        .extract().as(VacancySearchSuggestsErrorResponse.class));

        step("Проверка ответа", () -> {
            assertEquals("bad argument", response.getDescription());
            assertNotNull(response.getRequestId());
        });
    }
}
