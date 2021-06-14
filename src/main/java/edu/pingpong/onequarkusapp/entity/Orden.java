package edu.pingpong.onequarkusapp.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_ordenes")
public class Orden {

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
}
