package com.alperenyozcu.filmproject.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.parameters.P;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
public class Film implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FILMID",nullable = false)
    private int Filmid;

    @Column(name = "FILMNAME")
    private String filmname;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "DESCRIPTION", columnDefinition = "TEXT")
    private String description;

    @Temporal(TemporalType.DATE)
    @Column(name = "RELASED")
    private Date relased;

    @Column(name = "PRODUCTION")
    private String production;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade =
                    {
                            CascadeType.DETACH,
                            CascadeType.MERGE,
                            CascadeType.REFRESH,
                            CascadeType.PERSIST
                    },
            targetEntity = Languages.class)
    @JoinTable(name = "FILM_LANGUAGES",
            foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
            inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    private List<Languages> languages;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade =
                    {
                            CascadeType.DETACH,
                            CascadeType.MERGE,
                            CascadeType.REFRESH,
                            CascadeType.PERSIST
                    },
            targetEntity = Actors.class)
    @JoinTable(name = "FILM_ACTORS",
            foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
            inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    private List<Actors> actors;


}
