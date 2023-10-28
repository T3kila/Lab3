package com.mitocode.controller;


import com.mitocode.dto.MedicDTO;
import com.mitocode.dto.PatientDTO;
import com.mitocode.dto.PosicionDTO;
import com.mitocode.exception.ModelNotFoundException;
import com.mitocode.model.Medic;
import com.mitocode.model.Posiciones;
import com.mitocode.service.IPatientService;
import com.mitocode.service.IPosicionesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/posiciones")
public class PosicionController {


    @Autowired
    private IPosicionesService service;

    @Autowired
    private ModelMapper mapper;


    @GetMapping
    public ResponseEntity<List<PosicionDTO>> findAll() {
        List<PosicionDTO> list = service.findAll().stream().map(p -> mapper.map(p, PosicionDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody PosicionDTO dto) {
        Posiciones p = service.save(mapper.map(dto, Posiciones.class));
        //localhost:8080/medics/3
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getIdPosicion()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Posiciones> update(@Valid @RequestBody PosicionDTO dto) {
        Posiciones obj = service.findById(dto.getIdPosicion());
        if (obj == null) {
            throw new ModelNotFoundException("ID NOT FOUND: " + dto.getIdPosicion());
        }

        return new ResponseEntity<>(service.update(mapper.map(dto, Posiciones.class)), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id) {
        Posiciones obj = service.findById(id);
        if (obj == null) {
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        } else {
            service.delete(id);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
