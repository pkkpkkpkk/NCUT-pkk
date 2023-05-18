package com.ncut.myblog.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

    private Integer tid;
    private Integer id;
    private String name;
    private String gender;
    private String graduatedSchool;
    private String position;
    private String title;
    private String field;
    private String description;
    private String email;
    private String phone;
}
