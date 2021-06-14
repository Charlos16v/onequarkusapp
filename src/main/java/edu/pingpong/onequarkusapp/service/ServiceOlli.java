package edu.pingpong.onequarkusapp.service;

import edu.pingpong.onequarkusapp.entity.Usuaria;
import edu.pingpong.onequarkusapp.repository.RepositoryUsuaria;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Optional;

// Single bean instance
@ApplicationScoped
public class ServiceOlli {

    @Inject
    RepositoryUsuaria repositoryUsuaria;

    public ServiceOlli() {}


    public Usuaria cargaUsuaria(String nombre) {
        Optional<Usuaria> usuaria = this.repositoryUsuaria.getUsuariaByNombre(nombre);
        if (usuaria.isEmpty()) return new Usuaria("",0);
        return usuaria.get();
    }
}
