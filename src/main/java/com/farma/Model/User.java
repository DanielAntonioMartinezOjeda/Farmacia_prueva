package com.farma.Model;
/** ----------------------------------------- **/
/** Utilizando herramientas como Lombok, puedes reducir la cantidad de boilerplate code al permitir que la biblioteca genere automáticamente partes comunes del código por ti, **/
/** las librerias lombok ayudarana  reducir el codigo repetititvo que es nesesario poner pero no da mucha funcionalidad al codigo  **/
/**  esta libreria nos ayudara a generar automaticamente el codigo nesesario en los puntos nesesarios **/
/** "Boilerplate" es un término que se utiliza en programación para referirse a código repetitivo y estandarizado que se necesita escribir una y otra vez con poca o ninguna variación.  **/
import lombok.AllArgsConstructor; /** con esta linea estamos juntando todos los parametros de nuestra clase en una sola linea, para no tener que poner todos uno por uno  **/
import lombok.Data; /** **/
import lombok.NoArgsConstructor; /**  este es un constructor vacio, con la finalidad de crear una instancia de la clase, sin proporcionar valores inciales para los campos **/
/** ----------------------------------------- **/
import javax.persistence.*; /** es la poarte de manda a llamar las funciones de JPA para trabajar con BD. JPA es una especificación de Java que proporciona un estándar para mapear objetos Java a bases de datos relacionales.  **/
import java.util.HashSet; /** es una libreria q nos ayudara a ahcer la relacion entre entidaddes  **/
import java.util.Set; /** manda a llamar elementos unicos de la seccion, en este caso para nuestro login **/

@Data /** estamos amandando llamar la funcion de lombok llamda data, para q nos genere codigo automatico en metodo del mapeo de la BD orientada a objetos **/
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    /** ----------------------------------------------- **/
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /** aqui estamos creando la llave primaria y ponienido que sea autoincrementable  **/
    /** ------------------------------------------------ **/
    private Long id;

    private String username;

    private String password;

    private boolean enabled; /** es para verificar si la cuenta de usuario esta activa o inactica, si existe o no  **/
    /** --------------------------------------------------------------- **/
    /** --------------------------------------------------------------- **/
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
    /** en esta parte estamos haciendo las relaciones nesesarias entre ambas tablas que estamos utilizxando
     no esta diciendo que una ves ingresemos el usuario y passwor nos relacionara con la tabla roll para ver cual es
     su rol en el sistema, y si es un nuevo usuario para subirlo de inmediato al sistema y no perder tiempo **/

    /** --------------------------------------------------------------- **/
    /** --------------------------------------------------------------- **/
}
