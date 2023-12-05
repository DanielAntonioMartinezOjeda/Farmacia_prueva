package com.farma.Model;

import lombok.*;

import javax.persistence.*;


/**
 * Clase que representa una entidad Persona en el sistema. se crea tabla con nombre persona
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
@RequiredArgsConstructor
@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre", nullable = false, length = 80)
    private String nombre;

    @Column(name = "edad", nullable = true, length = 20)
    private int edad;

    @Column(name = "direccion", nullable = true , length = 40)
    private String direccion;

    @Column(name = "telefono", nullable = true, length = 100)
    private long telefono;

    @Column(name = "codigoPostal", nullable = true, length = 50)
    private long codigoPostal;

}



