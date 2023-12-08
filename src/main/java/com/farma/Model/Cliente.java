package com.farma.Model;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre", nullable = true, length = 20)
    private int nombre;

    @Column(name = "direccion", nullable = true, length = 20)
    private int direccion;

    @Column(name = "telefono", nullable = true, length = 20)
    private String telefono;

    @Column(name = "puntos", nullable = true, length = 20)
    private int puntos;
}
