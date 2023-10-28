package com.mitocode.service.impl;

import com.mitocode.model.Posiciones;
import com.mitocode.model.Specialty;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IPosicionesRepo;
import com.mitocode.repo.ISpecialtyRepo;
import com.mitocode.service.IPosicionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//extends CRUDImpl<Specialty, Integer> implements ISpecialtyService {
public class PosicionesImpl extends CRUDImpl <Posiciones, Integer> implements IPosicionesService {
    @Autowired
    private IPosicionesRepo repo;

    @Override
    protected IGenericRepo<Posiciones, Integer> getRepo() {
        return repo;
    }
}
