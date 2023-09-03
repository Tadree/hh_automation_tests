package ru.jiehk.autotests.tests.api.tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.jiehk.autotests.tests.api.models.PhoneConfirmErrorResponse;
import ru.jiehk.autotests.tests.api.models.VacancySearchResponse;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static ru.jiehk.autotests.tests.api.specs.RequestSpec.requestSpec;
import static ru.jiehk.autotests.tests.api.specs.ResponseSpec.*;

@Owner("Elena Kosiakova")
public class FavoriteVacanciesTests extends TestBase {

    @Test
    @Tag("api")
    @DisplayName("Проверка ошибки авторизации при добавлении вакансии в избранное")
    void AddVacancyToFavoriteWithoutAuthorizationTest() {
        TestData testData = new TestData();
        VacancySearchResponse vacancySearchResponse = step("Выполнение запроса на поиск вакансий", () ->
                given()
                        .spec(requestSpec)
                        .param("per_page", 1)
                        .when()
                        .get("/vacancies")
                        .then()
                        .spec(successResponseSpec)
                        .extract().as(VacancySearchResponse.class));

        PhoneConfirmErrorResponse phoneConfirmResponse = step("Выполнение запроса на добавление найденной вакансии в избранное", () ->
                given()
                        .spec(requestSpec)
                        .when()
                        .put("/vacancies/favorited/" + vacancySearchResponse.getItems().get(0).getId())
                        .then()
                        .spec(forbiddenErrorResponseSpec)
                        .extract().as(PhoneConfirmErrorResponse.class));

        step("Проверка ответа", () -> {
            assertEquals("forbidden", phoneConfirmResponse.getErrors().get(0).getType());
            assertNotNull(phoneConfirmResponse.getRequestId());
        });
    }
}
