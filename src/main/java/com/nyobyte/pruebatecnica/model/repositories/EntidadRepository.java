package com.nyobyte.pruebatecnica.model.repositories;

import com.nyobyte.pruebatecnica.model.dao.EntidadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EntidadRepository extends JpaRepository<EntidadEntity, Long> {

    @Query(value = "SELECT * FROM Entidad ORDER BY Entidad.id", nativeQuery = true)
    List<EntidadEntity> findAllEntidad();
}
