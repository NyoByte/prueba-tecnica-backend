package com.nyobyte.pruebatecnica.model.repositories;

import com.nyobyte.pruebatecnica.model.dao.TipoDocumentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoDocumentoRepository extends JpaRepository<TipoDocumentoEntity, Long> {
}
