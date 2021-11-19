package com.nyobyte.pruebatecnica.controller;

import com.nyobyte.pruebatecnica.model.dao.EntidadEntity;
import com.nyobyte.pruebatecnica.model.dao.TipoContribuyenteEntity;
import com.nyobyte.pruebatecnica.model.dao.TipoDocumentoEntity;
import com.nyobyte.pruebatecnica.model.dto.EntidadDTO;
import com.nyobyte.pruebatecnica.service.EntidadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/entidad")
public class EntidadController {
    private final EntidadService entidadService;

    public EntidadController(EntidadService entidadService) {
        this.entidadService = entidadService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<EntidadEntity>> getAllEntidad(){
        List<EntidadEntity> entidades = entidadService.findAllEntidad();
        return new ResponseEntity<>(entidades, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<EntidadEntity> getEntidadById(@PathVariable("id") Long id){
        EntidadEntity entidad = entidadService.findEntidadById(id);
        return new ResponseEntity<>(entidad, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<EntidadEntity> addEntidad(@RequestBody EntidadDTO entidadDTO){
        Long tipoDocumento_id = entidadDTO.getTipoDocumento_id();
        String nro_documento = entidadDTO.getNro_documento();
        String razon_social = entidadDTO.getRazon_social();
        String nombre_comercial;
        if (entidadDTO.getNombre_comercial().isEmpty()){
            nombre_comercial = null;
        }else{
            nombre_comercial = entidadDTO.getNombre_comercial();
        }

        String direccion = entidadDTO.getDireccion();
        String telefono = entidadDTO.getTelefono();

        Long tipoContribuyente_id = entidadDTO.getTipoContribuyente_id();
        if (tipoContribuyente_id == null){
            tipoContribuyente_id = 0L;
        }
        TipoDocumentoEntity opDoc= entidadService.findTipoDocumentoById(tipoDocumento_id);
        Optional<TipoContribuyenteEntity> opContrib = Optional.ofNullable(entidadService.findTipoContribuyenteById(tipoContribuyente_id));
        EntidadEntity newEntidad;
        if (opContrib.isPresent()){
            newEntidad = new EntidadEntity(null, nro_documento, razon_social, nombre_comercial, direccion, telefono, true, opDoc, opContrib.get());
        }else{
            newEntidad = new EntidadEntity(null, nro_documento, razon_social, nombre_comercial, direccion, telefono, true, opDoc);
        }
        EntidadEntity tempEntidad = entidadService.addEntidad(newEntidad);
        return new ResponseEntity<>(tempEntidad, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<EntidadEntity> updateEntidad(@RequestBody EntidadDTO entidadDTO){
        Long id = entidadDTO.getId();
        EntidadEntity entidadCurrent = entidadService.findEntidadById(id);
        Long tipoDocumento_id = entidadDTO.getTipoDocumento_id();
        entidadCurrent.setNro_documento(entidadDTO.getNro_documento());
        entidadCurrent.setRazon_social(entidadDTO.getRazon_social());
        entidadCurrent.setNombre_comercial(entidadDTO.getNombre_comercial());
        entidadCurrent.setDireccion(entidadDTO.getDireccion());
        entidadCurrent.setTelefono(entidadDTO.getTelefono());
        entidadCurrent.setEstado(entidadDTO.getEstado());

        Long tipoContribuyente_id = entidadDTO.getTipoContribuyente_id();
        if (tipoContribuyente_id == null){
            tipoContribuyente_id = 0L;
        }
        TipoDocumentoEntity opDoc= entidadService.findTipoDocumentoById(tipoDocumento_id);
        Optional<TipoContribuyenteEntity> opContrib = Optional.ofNullable(entidadService.findTipoContribuyenteById(tipoContribuyente_id));
        entidadCurrent.setTipoDocumento(opDoc);
        if (opContrib.isPresent()){
            entidadCurrent.setTipoContribuyente(opContrib.get());
        }
        EntidadEntity updatedEntidad = entidadService.updateEntidad(entidadCurrent);
        return new ResponseEntity<>(updatedEntidad, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEntidad(@PathVariable("id") Long id){
        entidadService.deleteEntidad(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
