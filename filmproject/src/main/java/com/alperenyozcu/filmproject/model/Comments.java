package com.alperenyozcu.filmproject.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
public class Comments implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="COMMENT_ID",nullable = false)
    private int comment_id;

    @Column(name = "CREATION_TIME", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date creationTime;

    @Column(name = "CONTEXT", nullable = false, columnDefinition = "TEXT")
    private String context;

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "USERID")
    private User user;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "FILMID", referencedColumnName = "FILMID")
    private Film film;
}
