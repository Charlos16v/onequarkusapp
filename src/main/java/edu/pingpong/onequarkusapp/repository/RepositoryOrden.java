package edu.pingpong.onequarkusapp.repository;

import edu.pingpong.onequarkusapp.entity.Orden;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class RepositoryOrden implements PanacheRepository<Orden> {

    public List<Orden> getOrdenesByNombre(String nombre) {
        return this.list("ord_user", nombre);
    }

    public Orden saveOrder(Orden orden) {
        this.persist(orden);
        return orden;
    }
}
