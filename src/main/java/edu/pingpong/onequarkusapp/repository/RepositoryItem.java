package edu.pingpong.onequarkusapp.repository;

import edu.pingpong.onequarkusapp.entity.Item;
import edu.pingpong.onequarkusapp.entity.Usuaria;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class RepositoryItem implements PanacheRepository<Item> {

    public Optional<Item> getItemByNombre(String nombre) {
        return this.find("item_nom", nombre).firstResultOptional();
    }
}
