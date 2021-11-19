package com.nyobyte.pruebatecnica.model.repositories;

import com.nyobyte.pruebatecnica.model.dao.TipoDocumentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TipoDocumentoRepository extends JpaRepository<TipoDocumentoEntity, Long> {
    @Query(value = "SELECT * FROM Tipo_Documento ORDER BY CAST(Tipo_Documento.codigo AS INT) ASC", nativeQuery = true)
    List<TipoDocumentoEntity>  findAllTipoDocumento();
}
