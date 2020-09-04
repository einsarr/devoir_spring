package com.devoirjee.devoir_spring.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.management.relation.Role;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long user_id;
    @Column(length = 10)
    private String code;
    @Column(length = 30)
    private String prenom;
    @Column(length = 25)
    private String nom;
    @Column(length = 10)
    private String num_contrat;
    @Column(length = 50)
    private String username;
    @Column(length = 50)
    private String password;
    @Column(length = 10)
    private String etat;
    private boolean changed;
    @OneToMany(mappedBy = "caissier_env")
    private List<Operation> caissier_envois;
    @OneToMany(mappedBy = "caissier_rec")
    private List<Operation> caissier_recus;
    @OneToOne(mappedBy = "user")
    private Compte compte;
    @OneToMany(mappedBy = "user")
    private List<AlimenterCompte> alimenterComptes;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @JsonIgnoreProperties("user")
    private List<Roles> roles;




}
