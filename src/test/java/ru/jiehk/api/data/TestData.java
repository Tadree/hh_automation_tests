package ru.jiehk.api.data;

import com.github.javafaker.Faker;

public class TestData {

    Faker faker = new Faker();

    public String
            phoneNumber = faker.phoneNumber().subscriberNumber(10),
            code = faker.number().digits(4);
}
