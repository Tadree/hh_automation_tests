package ru.jiehk.api.models;

import lombok.Data;

@Data
public class PhoneConfirmRequest {

    private String phone, code;
}
