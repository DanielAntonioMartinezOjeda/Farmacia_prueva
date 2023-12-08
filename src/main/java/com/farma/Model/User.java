package com.farma.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;


@Valid
@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @Transient
    private String _id;

    @NotEmpty(message = "El campo es requerido")
    @Column(name = "password" )
    private String password;

    @JsonIgnore
    @Transient
    private String confirmpassword;

    @NotBlank(message = "El campo es requerido")
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @NotEmpty(message = "El campo es requerido")
    @Column(name = "apellidos", nullable = false)
    private String apellidos;

    @Column(name = "telefono" ,nullable = false)
    private String telefono;

    @NotEmpty(message = "El campo es requerido")
    @Email
    @Column(name = "email",  nullable = false)
    private String email;

    @Column(name = "enabled")
    private boolean enabled;

    @ManyToOne
    @JoinColumn(name = "roles_id")
    private Role role;


}
