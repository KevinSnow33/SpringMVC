package com.kevinsnow.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Data
public class User {
    private String name;
    private long id;
    private String password;
    private boolean checkboxFlag;
    private List<String> allHobbys;
    private List<String> selectedHobbys;
    private int grade;
    private Map<Integer,String> gradeMap;
    private int[] city;
    private Map<Integer,String> cityMap;
    private String textareaDefault;

    public User(String name, long id) {
        this.name = name;
        this.id = id;
    }

}
