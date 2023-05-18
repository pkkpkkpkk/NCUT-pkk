package com.ncut.myblog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostUser {

    private Integer yid;
    private String id;
    private Integer gender;
    private String city;
    private String career;
    private String phone;
    private String email;
    private String name;
}
