package ru.jiehk.autotests.tests.api.helpers.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static org.hamcrest.Matchers.notNullValue;

public class ResponseSpec {
    public static ResponseSpecification successResponseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .expectBody(notNullValue())
            .build();

    public static ResponseSpecification badRequestErrorResponseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(400)
            .expectBody(notNullValue())
            .build();

    public static ResponseSpecification forbiddenErrorResponseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(403)
            .expectBody(notNullValue())
            .build();
}
