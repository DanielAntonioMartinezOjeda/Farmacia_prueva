package com.farma.Model;
import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    // <editor-fold defaultstate="collapsed" desc="Variables">

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Propiedades">
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // </editor-fold>
}
