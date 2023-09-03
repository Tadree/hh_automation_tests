package ru.jiehk.autotests.tests.api.tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.jiehk.autotests.tests.api.models.EmployersSearchResponse;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.jiehk.autotests.tests.api.specs.ResponseSpec.successResponseSpec;
import static ru.jiehk.autotests.tests.api.specs.RequestSpec.requestSpec;

@Owner("Elena Kosiakova")
@Tag("api")
public class EmployersSearchTests extends TestBase {

    @ParameterizedTest(name = "Поиск работодателя с наименование {0}")
    @ValueSource(strings = {"впрок", "headhunter"})
    @DisplayName("Проверка поиска работодателя по наименованию")
    void employersSearchTest(String searchQuery) {
        EmployersSearchResponse response = step("Выполнение запроса на поиск работодателя", () ->
                given()
                        .spec(requestSpec)
                        .param("text", searchQuery)
                        .when()
                        .get("/employers")
                        .then()
                        .spec(successResponseSpec)
                        .extract().as(EmployersSearchResponse.class));

        step("Проверка ответа", () ->
                assertThat(response.getItems().get(0).getName()).containsIgnoringCase(searchQuery));
    }

    @Test
    @DisplayName("Проверка пагинации при поиске работодателя")
    void employersSearchPaginationTest() {
        EmployersSearchResponse response = step("Выполнение запроса на поиск работодателя", () ->
                given()
                        .spec(requestSpec)
                        .param("per_page", 1)
                        .when()
                        .get("/employers")
                        .then()
                        .spec(successResponseSpec)
                        .extract().as(EmployersSearchResponse.class));

        step("Проверка ответа", () ->
                assertEquals(response.getPerPage(), response.getItems().size()));
    }
}
