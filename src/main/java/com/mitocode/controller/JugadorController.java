package com.mitocode.controller;

import com.mitocode.dto.JugadorDTO;
import com.mitocode.dto.PosicionDTO;
import com.mitocode.exception.ModelNotFoundException;
import com.mitocode.model.Jugador;
import com.mitocode.model.Posiciones;
import com.mitocode.service.IJugadoresService;
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
@RequestMapping("/Jugador")
public class JugadorController {

    @Autowired
    private IJugadoresService service;

    @Autowired
    private ModelMapper mapper;


    @GetMapping
    public ResponseEntity<List<JugadorDTO>> findAll() {
        List<JugadorDTO> list = service.findAll().stream().map(p -> mapper.map(p, JugadorDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody JugadorDTO dto) {
        Jugador p = service.save(mapper.map(dto, Jugador.class));
        //localhost:8080/medics/3
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getIdplayer()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Jugador> update(@Valid @RequestBody JugadorDTO dto) {
        Jugador obj = service.findById(dto.getIdplayer());
        if (obj == null) {
            throw new ModelNotFoundException("ID NOT FOUND: " + dto.getIdplayer());
        }

        return new ResponseEntity<>(service.update(mapper.map(dto, Jugador.class)), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id) {
        Jugador obj = service.findById(id);
        if (obj == null) {
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        } else {
            service.delete(id);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
