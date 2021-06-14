package edu.pingpong.onequarkusapp.service;

import edu.pingpong.onequarkusapp.entity.Item;
import edu.pingpong.onequarkusapp.entity.Usuaria;
import edu.pingpong.onequarkusapp.repository.RepositoryItem;
import edu.pingpong.onequarkusapp.repository.RepositoryUsuaria;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Optional;

// Single bean instance
@ApplicationScoped
public class ServiceOlli {

    @Inject
    RepositoryUsuaria repositoryUsuaria;

    @Inject
    RepositoryItem repositoryItem;

    public ServiceOlli() {}


    public Usuaria cargaUsuaria(String nombre) {
        Optional<Usuaria> usuaria = this.repositoryUsuaria.getUsuariaByNombre(nombre);
        if (usuaria.isEmpty()) return new Usuaria("",0);
        return usuaria.get();
    }

    public Item cargaItem(String nombre) {
        Optional<Item> item = this.repositoryItem.getItemByNombre(nombre);
        if (item.isEmpty()) return new Item("", 0);
        return item.get();
    }
}
