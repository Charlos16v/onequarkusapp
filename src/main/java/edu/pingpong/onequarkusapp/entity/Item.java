package edu.pingpong.onequarkusapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_items")
public class Item {

    @Id
    @Column(name = "item_nom")
    public String nombre;

    @Column(name = "item_prop")
    public Integer quality;

    @Column(name = "item_tipo")
    public String tipo;

    public Item() {}

    public Item(String nombre, Integer quality, String tipo) {
        this.nombre = nombre;
        this.quality = quality;
        this.tipo = tipo;
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
