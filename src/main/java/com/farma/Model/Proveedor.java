package com.farma.Model;


import lombok.*;

import javax.persistence.*;


@Data
@AllArgsConstructor
@EqualsAndHashCode
@RequiredArgsConstructor
@Entity
@Table(name = "proveedor")
public class Proveedor {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "direccion", nullable = true, length = 200)
    private String direccion;

    @Column(name = "telefono", nullable = true, length = 100 )
    private int telefono;
}
