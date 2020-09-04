package com.devoirjee.devoir_spring.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Roles implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long role_id;
    @Column(length = 20)
    private String libelle_role;
    @Column(length = 7)
    private String etat_role;

    @ManyToMany(mappedBy = "roles")
    @JsonIgnoreProperties("roles")
    private List<Users> users;
/*
    @ManyToMany(mappedBy = "roles")
    @JsonIgnoreProperties("roles")
    private List<Users> users;*/

}
