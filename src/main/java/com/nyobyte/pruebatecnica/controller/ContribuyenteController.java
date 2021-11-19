package com.nyobyte.pruebatecnica.controller;

import com.nyobyte.pruebatecnica.model.dao.TipoContribuyenteEntity;
import com.nyobyte.pruebatecnica.model.dao.TipoDocumentoEntity;
import com.nyobyte.pruebatecnica.service.EntidadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/contribuyente")
public class ContribuyenteController {
    private final EntidadService entidadService;

    public ContribuyenteController(EntidadService entidadService) {
        this.entidadService = entidadService;
    }

    @GetMapping("/all")
    public List<TipoContribuyenteEntity> getAllTipoContribuyente(){
        return entidadService.findAllTipoContribuyente();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<TipoContribuyenteEntity> getTipoContribuyenteById(@PathVariable("id") Long id){
        TipoContribuyenteEntity contribuyente = entidadService.findTipoContribuyenteById(id);
        return new ResponseEntity<>(contribuyente, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<TipoContribuyenteEntity> addTipoContribuyente(@RequestBody TipoContribuyenteEntity contribuyente){
        String nombre = contribuyente.getNombre();

        TipoContribuyenteEntity newTipoContribuyente = new TipoContribuyenteEntity(null, nombre, true);
        TipoContribuyenteEntity tempContribuyente= entidadService.addTipoContribuyente(newTipoContribuyente);
        return new ResponseEntity<>(tempContribuyente, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<TipoContribuyenteEntity> updateTipoContribuyente(@RequestBody TipoContribuyenteEntity contribuyente){
        Long id = contribuyente.getId();
        TipoContribuyenteEntity contribuyenteCurrent = entidadService.findTipoContribuyenteById(id);
        contribuyenteCurrent.setNombre(contribuyente.getNombre());
        contribuyenteCurrent.setEstado(contribuyente.getEstado());
        TipoContribuyenteEntity updateContribuyente = entidadService.updateTipoContribuyente(contribuyenteCurrent);
        return new ResponseEntity<>(updateContribuyente, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTipoContribuyente(@PathVariable("id") Long id){
        entidadService.deleteTipoContribuyente(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
