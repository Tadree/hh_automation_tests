package ru.jiehk.autotests.tests.api.helpers.specs;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;
import static ru.jiehk.autotests.tests.api.helpers.CustomApiListener.withCustomTemplates;

public class RequestSpec {
    public static RequestSpecification requestSpec = with()
            .filter(withCustomTemplates())
            .log().all()
            .contentType(JSON);
}
