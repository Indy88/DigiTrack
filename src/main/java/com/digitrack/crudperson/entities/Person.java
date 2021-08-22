package com.digitrack.crudperson.entities;

import javax.persistence.*;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Id;

import java.util.Date;

@Entity
@Table(name = "PERSON")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    @Getter @Setter public Long id;

    @Column (name="fullname", nullable = false)
    @NotNull
    @Getter @Setter private String fullname;

    @Column // campo oblifatorio
    @Getter @Setter private int cpf;

    @Column
    @Getter @Setter  private Date datebirth;

    @Column
    @Getter @Setter  private String email;

    @Column
    @Getter @Setter  private Gender sex;  //obligatorio

    @Column
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
