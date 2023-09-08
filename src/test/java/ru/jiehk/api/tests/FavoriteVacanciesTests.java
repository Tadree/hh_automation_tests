package ru.jiehk.api.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.jiehk.api.data.TestData;
import ru.jiehk.api.models.PhoneConfirmErrorResponse;
import ru.jiehk.api.models.VacancySearchResponse;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static ru.jiehk.api.specs.RequestSpec.requestSpec;
import static ru.jiehk.api.specs.ResponseSpec.*;

@Tag("api")
@Owner("Elena Kosiakova")
@Epic("API tests")
@Feature("Add to favorite request")
public class FavoriteVacanciesTests extends TestBase {

    @Test
    @DisplayName("Проверка ошибки авторизации при добавлении вакансии в избранное")
    void AddVacancyToFavoriteWithoutAuthorizationTest() {
        VacancySearchResponse vacancySearchResponse = step("Выполнение запроса на поиск вакансий", () ->
                given()
                        .spec(requestSpec)
                        .param("per_page", 1)
                        .when()
                        .get("/vacancies")
                        .then()
                        .spec(responseSpecCode200)
                        .extract().as(VacancySearchResponse.class));

        PhoneConfirmErrorResponse phoneConfirmResponse = step("Выполнение запроса на добавление найденной вакансии в избранное", () ->
                given()
                        .spec(requestSpec)
                        .when()
                        .put("/vacancies/favorited/" + vacancySearchResponse.getItems().get(0).getId())
                        .then()
                        .spec(responseSpecCode403)
                        .extract().as(PhoneConfirmErrorResponse.class));

        step("Проверка ответа", () -> {
            assertEquals("forbidden", phoneConfirmResponse.getErrors().get(0).getType());
            assertNotNull(phoneConfirmResponse.getRequestId());
        });
    }
}
