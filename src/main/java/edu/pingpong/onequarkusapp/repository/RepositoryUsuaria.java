package edu.pingpong.onequarkusapp.repository;

import edu.pingpong.onequarkusapp.entity.Usuaria;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class RepositoryUsuaria implements PanacheRepository<Usuaria> {


    public Optional<Usuaria> getUsuariaByNombre(String nombre) {
        return this.find("user_nom", nombre).firstResultOptional();
    }
}
