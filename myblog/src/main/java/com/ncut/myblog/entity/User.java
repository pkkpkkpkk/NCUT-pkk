package com.ncut.myblog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private Integer uid;
    private String username;
    private String password;

    private String gender;

    private Date createdTime;

    private Date modifiedTime;

    private String telephone;
    private String email;

    private String hobby;
    private String signature;
    private String isAdmin;


}
