package com.digitrack.crudperson.entities;

import javax.persistence.*;

//import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Id;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "PERSON")
@Getter @Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long id;

    @Column (name="fullname", nullable = false)
    @NotNull
    private String fullname; //max 60 caracteres

    @Column (name="cpf", nullable = false)  //maximo 11 caracteres
   // @Size(min = 11, max = 11)
    @NotNull
	private String cpf;

    @Column(name="datebirth")
    @NotNull
    @Past
    private Date datebirth; //validacion

    @Column(name="email")
   // @Email()
    @NotNull
    private String email; //validacion

    @Column (name="sex", nullable = false)
    @NotNull
    private boolean sex;  //obligatorio

    @Column(name="phone")
    private String phone;

    @Column(name="description")
    private String description;

    @Column(name="neighborhood",  nullable = false)
    @NotNull
    private String neighborhood;

    @Column(name="codeNumber", nullable = false)
    @NotNull
    private String codeNumber;

    @Column(name="city", nullable = false)
    @NotNull
    private String city;

    @Column(name="address", nullable = false)
    @NotNull
    private String address;

    @Column(name="latitude", nullable = false)
    @NotNull
    private int latitude;

    @Column(name="longitude", nullable = false)
    @NotNull
    private int longitude;

    @Column(name = "created_at")
    @CreatedDate
    @Temporal(TemporalType.DATE)
    private Date created_at;

    @Column(name = "updated_at")
    @Temporal(TemporalType.DATE)
    private Date updated_at;


}
