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
    public String nom;

    @Column(name = "pro")
}
