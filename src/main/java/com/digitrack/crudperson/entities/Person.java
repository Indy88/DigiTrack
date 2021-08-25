package com.digitrack.crudperson.entities;

import javax.persistence.*;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Id;
import javax.validation.constraints.*;
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
    @Size(max = 60)
    @Getter @Setter private String fullname; //max 60 caracteres

    @Column (name="cpf", nullable = false)  //maximo 11 caracteres
    @Size(min = 11, max = 11)
    @Min(11)
    @NotNull
    @Getter @Setter private int cpf;

    @Column(name="datebirth", nullable = false)
    @NotNull
    @Past
    @Getter @Setter  private Date datebirth; //validacion

    @Column(name="email", nullable = false)
    @Email()
    @NotNull
    @Getter @Setter  private String email; //validacion

    @Column (name="sex", nullable = false)
    @NotNull
    @Getter @Setter  private boolean sex;  //obligatorio

    @Column(name="phone")
    @Getter @Setter  private String phone;

    @Column
    @Getter @Setter private String description;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Getter @Setter private Date created_at;

    @Column(name = "updated_at")
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter  private Date updated_at;


}
