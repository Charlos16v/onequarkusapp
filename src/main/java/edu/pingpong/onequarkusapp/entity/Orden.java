package edu.pingpong.onequarkusapp.entity;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Entity
@Table(name = "t_ordenes")
public class Orden extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ord_id")
    public Long id;


    @OneToOne
    @JoinColumn(name = "ord_user")
    private Usuaria user;

    @OneToOne
    @JoinColumn(name = "ord_item")
    public Item item;

    public Orden() {}

    public Orden(Usuaria user, Item item) {
        this.user = user;
        this.item = item;
    }

    public Orden(Long id, Usuaria user, Item item) {
        this.id = id;
        this.user = user;
        this.item = item;
    }

    public Usuaria getUser() {
        return user;
    }

    public Item getItem() {
        return item;
    }

    public Long getId() {
        return this.id;
    }
}
