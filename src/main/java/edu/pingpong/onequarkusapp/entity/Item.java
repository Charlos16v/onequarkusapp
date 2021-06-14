package edu.pingpong.onequarkusapp.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "t_items")
public class Item extends PanacheEntityBase {

    @Id
    @NotNull(message = "Nombre may not be null")
    @Column(name = "item_nom")
    public String nombre;

    @Column(name = "item_prop")
    public Integer quality;

    @Column(name = "item_tipo")
    public String tipo;

    public Item() {}

    public Item(String nombre, Integer quality) {
        this.nombre = nombre;
        this.quality = quality;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getQuality() {
        return quality;
    }

    public String getTipo() {
        return tipo;
    }
}
