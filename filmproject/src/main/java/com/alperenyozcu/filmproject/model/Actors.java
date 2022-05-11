package com.alperenyozcu.filmproject.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
public class Actors implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int Actorid;

    @Column(name = "ACTORNAME")
    private String actorname;

    @Column(name = "ACTORSURNAME")
    private  String actorsurname;


}
