package ru.jiehk.autotests.tests.api.models;

import lombok.Data;

@Data
public class PhoneConfirmRequest {
    private String phone, code;
}
