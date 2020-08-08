package com.wandercosta.example.client;

import lombok.Data;

@Data
public class School {

    private long id;
    private String name;
    private String address;

    public String toString() {
        return String.format("School(%d,%s,%s)", id, name, address);
    }
}
