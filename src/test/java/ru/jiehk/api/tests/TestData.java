package ru.jiehk.api.tests;

import com.github.javafaker.Faker;

public class TestData {

    Faker faker = new Faker();

    String
            phoneNumber = faker.phoneNumber().subscriberNumber(10),
            code = faker.number().digits(4);
}
