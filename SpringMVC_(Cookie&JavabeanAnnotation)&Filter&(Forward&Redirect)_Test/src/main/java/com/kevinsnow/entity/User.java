package com.kevinsnow.entity;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private String name;
    private long id;
    private Address address;
    private List<Double> score;
}
