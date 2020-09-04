package com.devoirjee.devoir_spring.model;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;
import java.util.List;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long client_id;
    @Column(length = 17)
    private String numero_piece;
    @Column(length = 30)
    private String nom;
    @Column(length = 40)
    private String prenom;
    @Column(length = 16)
    private String telephone;

    @OneToMany(mappedBy = "client_env")
    private List<Operation> envois;

    @OneToMany(mappedBy = "client_rec")
    private List<Operation> recus;





}
