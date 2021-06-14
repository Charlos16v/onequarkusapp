package edu.pingpong.onequarkusapp.service;

import edu.pingpong.onequarkusapp.entity.Item;
import edu.pingpong.onequarkusapp.entity.Orden;
import edu.pingpong.onequarkusapp.entity.Usuaria;
import edu.pingpong.onequarkusapp.repository.RepositoryItem;
import edu.pingpong.onequarkusapp.repository.RepositoryOrden;
import edu.pingpong.onequarkusapp.repository.RepositoryUsuaria;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

// Single bean instance
@ApplicationScoped
public class ServiceOlli {

    @Inject
    RepositoryUsuaria repositoryUsuaria;

    @Inject
    RepositoryItem repositoryItem;

    @Inject
    RepositoryOrden repositoryOrden;

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

    public List<Orden> cargaOrden(String nombre) {
        List<Orden> ordenList = repositoryOrden.getOrdenesByNombre(nombre);
        if (ordenList.isEmpty()) return Collections.emptyList();
        return ordenList;
    }

    public Orden comanda(String usuariaNombre, String itemNombre) {
        Optional<Usuaria> usuaria = repositoryUsuaria.getUsuariaByNombre(usuariaNombre);
        Optional<Item> item = repositoryItem.getItemByNombre(itemNombre);

        if (usuaria.isEmpty() || item.isEmpty()) {
            return null;
        }
        if (usuaria.get().getDestreza() < item.get().getQuality()) return null;

        Orden newOrden = new Orden(usuaria.get(), item.get());
        return repositoryOrden.saveOrder(newOrden);
    }
}
