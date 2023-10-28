package com.mitocode.service.impl;


import com.mitocode.model.Jugador;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IJugadoresRepo;
import com.mitocode.service.IJugadoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

//extends CRUDImpl<Specialty, Integer> implements ISpecialtyService {
public class JugadorImpl extends  CRUDImpl<Jugador, Integer> implements IJugadoresService {
    @Autowired
    private IJugadoresRepo repo;

    @Override
    protected IGenericRepo<Jugador, Integer> getRepo() {
        return repo;
    }

}
