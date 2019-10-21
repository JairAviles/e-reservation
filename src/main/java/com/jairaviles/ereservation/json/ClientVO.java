package com.jairaviles.ereservation.json;

import lombok.Data;

@Data
public class ClientVO {
    private String idClient;
    private String first;
    private String last;
    private String username;
    private String address;
    private String phone;
    private String email;
}
