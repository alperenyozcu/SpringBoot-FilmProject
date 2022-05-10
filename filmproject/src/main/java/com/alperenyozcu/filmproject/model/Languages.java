package com.alperenyozcu.filmproject.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class Languages implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LANDID",nullable = false)
    private int Langid;

    @Column(name = "LANGUAGE")
    private  String language;

}
