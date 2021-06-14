package edu.pingpong.onequarkusapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_users")
public class Usuaria {

    @Id
    @Column(name = "user_nom")
    public String nombre;

    @Column(name = "user_prop")
    public Integer destreza;

    public Usuaria() {}

    public Usuaria(String nombre, Integer destreza) {
        this.nombre = nombre;
        this.destreza = destreza;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getDestreza() {
        return destreza;
    }
}
