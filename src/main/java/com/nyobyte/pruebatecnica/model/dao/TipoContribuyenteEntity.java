package com.nyobyte.pruebatecnica.model.dao;

import javax.persistence.*;

@Entity
@Table(name = "Tipo_Contribuyente")
public class TipoContribuyenteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "Estado", nullable = false)
    private Boolean estado = true;

    public TipoContribuyenteEntity() {
    }

    public TipoContribuyenteEntity(Long id, String nombre, Boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

}
