package edu.pingpong.onequarkusapp.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "t_users")
public class Usuaria extends PanacheEntityBase {

    @Id
    @NotNull(message = "Nombre may not be null")
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
