package com.farma.Model;

import javax.persistence.*;

/**Aqui estamos comensando a hacer el mapeo de la tabla rol de nuestra base de datos  **/
@Entity  /** con este comando estamos indicando el inicio de la entidad JPA, una entidad es una clase que representa una tabla en la base de datos. En este caso, la tabla se llamará "roles". **/
@Table(name = "roles")  /** Aqui estamos especificando el nombre de la tabla de nuestra base de datos  **/
public class Role
{
    /** ----------------------------------------- **/
    @Id
    @Column(name = "role_id") /** en esta parte estamos colocando la sintaxis para colocar la llave primaria  **/

    /** ------------------------------------------  **/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /** Con esta linea de condigo, estamos especificando que la primary key se colocara en automatico de manera desendiente es decir 1 , 2 , 3 , ..... **/
    private Integer id; /** aqui se estan declarando el tipo de variable para cada dato, en este caso es un dato de tipo entero. **/

    @Column(name = "name")
    private String name;
    /** de igual manera en este punto se esta declarando la otra variable de tipo cadena **/
}
