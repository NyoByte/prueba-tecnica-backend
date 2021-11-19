package com.nyobyte.pruebatecnica.model.dao;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Tipo_Documento")
public class TipoDocumentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Codigo", length = 20, nullable = false)
    private String codigo;

    @Column(name = "Nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "Descripcion", length = 200)
    private String descripcion = null;

    @Column(name = "Estado", nullable = false)
    private Boolean estado = true;

    public TipoDocumentoEntity() {
    }

    public TipoDocumentoEntity(Long id, String codigo, String nombre, String descripcion, Boolean estado) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

}
