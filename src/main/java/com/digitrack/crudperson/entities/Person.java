package com.digitrack.crudperson.entities;

import javax.persistence.*;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Id;
//import javax.validation;  add validadccion

import java.util.Date;

@Entity
@Table(name = "PERSON")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Getter @Setter public Long id;

    @Column (name="fullname", nullable = false)
    @NotNull
    @Getter @Setter private String fullname; //max 60 caracteres

    @Column (name="cpf", nullable = false)  //maximo 11 caracteres
    @Getter @Setter private int cpf;

    @Column(name="datebirth")
    @Getter @Setter  private Date datebirth; //validacion

    @Column(name="email")
    @Getter @Setter  private String email; //validacion

    @Column (name="sex", nullable = false)
    @Getter @Setter  private int sex;  //obligatorio

    @Column(name="phone")
    @Getter @Setter  private int phone;

    @Column
    @Getter @Setter private String description;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter private Date created_at;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter  private Date updated_at;


}
