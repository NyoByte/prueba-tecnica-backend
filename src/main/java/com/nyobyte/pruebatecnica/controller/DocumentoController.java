package com.nyobyte.pruebatecnica.controller;

import com.nyobyte.pruebatecnica.model.dao.TipoDocumentoEntity;
import com.nyobyte.pruebatecnica.service.EntidadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/documento")
public class DocumentoController {
    private final EntidadService entidadService;

    public DocumentoController(EntidadService entidadService) {
        this.entidadService = entidadService;
    }

    @GetMapping("/all")
    public List<TipoDocumentoEntity> getAllTipoDocumento(){
        return entidadService.findAllTipoDocumento();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<TipoDocumentoEntity> getTipoDocumentoById(@PathVariable("id") Long id){
        TipoDocumentoEntity documento = entidadService.findTipoDocumentoById(id);
        return new ResponseEntity<>(documento, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<TipoDocumentoEntity> addTipoDocumento(@RequestBody TipoDocumentoEntity documento){
        String descripcion;
        if (documento.getDescripcion().isEmpty()){
            descripcion = null;
        }else{
            descripcion = documento.getDescripcion();
        }
        String codigo = documento.getCodigo();
        String nombre = documento.getNombre();

        TipoDocumentoEntity newTipoDocumento = new TipoDocumentoEntity(null, codigo, nombre, descripcion, true);
        TipoDocumentoEntity tempDocumento = entidadService.addTipoDocumento(newTipoDocumento);
        return new ResponseEntity<>(tempDocumento, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<TipoDocumentoEntity> updateTipoDocumento(@RequestBody TipoDocumentoEntity documento){
        Long id = documento.getId();
        TipoDocumentoEntity documentoCurrent = entidadService.findTipoDocumentoById(id);
        documentoCurrent.setNombre(documento.getNombre());
        documentoCurrent.setCodigo(documento.getCodigo());
        documentoCurrent.setDescripcion(documento.getDescripcion());
        documentoCurrent.setEstado(documento.getEstado());
        TipoDocumentoEntity updateDocumento = entidadService.updateTipoDocumento(documentoCurrent);
        return new ResponseEntity<>(updateDocumento, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTipoDocumento(@PathVariable("id") Long id){
        entidadService.deleteTipoDocumento(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
