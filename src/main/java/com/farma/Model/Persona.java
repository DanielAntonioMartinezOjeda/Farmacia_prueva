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

    /**
     * Identificador único de la persona.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Nombre de la persona.
     */
    @Column(name = "nombre", nullable = false, length = 80)
    private String nombre;

    /**
     * Edad de la persona.
     */
    @Column(name = "edad", nullable = true, length = 20)
    private int edad;

    /**
     * Dirección de la persona.
     */
    @Column(name = "direccion", nullable = true , length = 40)
    private String direccion;

    /**
     * Número de teléfono de la persona.
     */
    @Column(name = "telefono", nullable = true, length = 100)
    private long telefono;

    /**
     * Código postal de la dirección de la persona.
     */
    @Column(name = "codigoPostal", nullable = true, length = 50)
    private long codigoPostal;

}



