package com.alperenyozcu.filmproject.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USERID",nullable = false)
    private int userid;

    @Column(name = "USERNAME")
    private  String username;

    @Column(name = "USERSURNAME")
    private  String usersurname;

    @Column(name = "EMAİL")
    private String email;

    @Column(name = "PASSWORD")
    private  String password;

    @Column(name = "ROLE")
    private String role;



}
