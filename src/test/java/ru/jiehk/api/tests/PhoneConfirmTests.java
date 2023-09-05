package ru.jiehk.api.tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.jiehk.api.data.TestData;
import ru.jiehk.api.models.PhoneConfirmErrorResponse;
import ru.jiehk.api.models.PhoneConfirmRequest;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static ru.jiehk.api.specs.RequestSpec.requestSpec;
import static ru.jiehk.api.specs.ResponseSpec.forbiddenErrorResponseSpec;

@Tag("api")
@Owner("Elena Kosiakova")
public class PhoneConfirmTests extends TestBase {

    @Test
    @DisplayName("Проверка ошибки авторизации при подтверждении номера телефона")
    void phoneConfirmWithoutAuthorizationTest() {
        TestData testData = new TestData();
        PhoneConfirmRequest body = new PhoneConfirmRequest();
        body.setPhone(testData.phoneNumber);
        body.setCode(testData.code);
        PhoneConfirmErrorResponse response = step("Выполнение запроса на подтверждение номера телефона", () ->
                given()
                        .spec(requestSpec)
                        .body(body)
                        .when()
                        .post("/resume_phone_confirm")
                        .then()
                        .spec(forbiddenErrorResponseSpec)
                        .extract().as(PhoneConfirmErrorResponse.class));

        step("Проверка ответа", () -> {
            assertEquals("forbidden", response.getErrors().get(0).getType());
            assertNotNull(response.getRequestId());
        });
    }
}
