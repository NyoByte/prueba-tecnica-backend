package com.nyobyte.pruebatecnica.service;

import com.nyobyte.pruebatecnica.model.dao.EntidadEntity;
import com.nyobyte.pruebatecnica.model.dao.TipoContribuyenteEntity;
import com.nyobyte.pruebatecnica.model.dao.TipoDocumentoEntity;
import com.nyobyte.pruebatecnica.model.repositories.EntidadRepository;
import com.nyobyte.pruebatecnica.model.repositories.TipoContribuyenteRepository;
import com.nyobyte.pruebatecnica.model.repositories.TipoDocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EntidadService {
    private final EntidadRepository entidadRep;
    private final TipoDocumentoRepository tipoDocRep;
    private final TipoContribuyenteRepository tipoContribRep;

    @Autowired
    public EntidadService(EntidadRepository entidadRep, TipoDocumentoRepository tipoDocRep, TipoContribuyenteRepository tipoContribRep) {
        this.entidadRep = entidadRep;
        this.tipoDocRep = tipoDocRep;
        this.tipoContribRep = tipoContribRep;
    }

    public EntidadEntity addEntidad(EntidadEntity entidad) {
        return entidadRep.save(entidad);
    }

    public List<EntidadEntity> findAllEntidad(){
        return entidadRep.findAllEntidad();
    }

    public EntidadEntity updateEntidad(EntidadEntity entidad) {
        return entidadRep.save(entidad);
    }

    public EntidadEntity findEntidadById(Long id){
        return entidadRep.findById(id).orElse(null);
    }

    public void deleteEntidad(Long id){
        entidadRep.deleteById(id);
    }

    public List<TipoDocumentoEntity> findAllTipoDocumento(){
        return tipoDocRep.findAll();
    }

    public TipoDocumentoEntity findTipoDocumentoById(Long id){
        return tipoDocRep.findById(id).orElse(null);
    }

    public List<TipoContribuyenteEntity> findAllTipoContribuyente(){
        return tipoContribRep.findAll();
    }

    public TipoContribuyenteEntity findTipoContribuyenteById(Long id){
        return tipoContribRep.findById(id).orElse(null);
    }
}
