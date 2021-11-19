package com.nyobyte.pruebatecnica.model.dao;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Entidad")
public class EntidadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nro_Documento", unique = true, length = 25, nullable = false)
    private String nro_documento;

    @Column(name = "Razon_Social", length = 100, nullable = false)
    private String razon_social;

    @Column(name = "Nombre_Comercial", length = 100)
    private String nombre_comercial = null;

    @Column(name = "Direccion", length = 250)
    private String direccion = null;

    @Column(name = "Telefono", length = 50)
    private String telefono = null;

    @Column(name = "Estado", nullable = false)
    private Boolean estado = true;

    @ManyToOne
    private TipoDocumentoEntity tipoDocumento;

    @ManyToOne
    private TipoContribuyenteEntity tipoContribuyente;

    public EntidadEntity() {
    }

    public EntidadEntity(Long id, String nro_documento, String razon_social, String nombre_comercial, String direccion, String telefono, Boolean estado) {
        this.id = id;
        this.nro_documento = nro_documento;
        this.razon_social = razon_social;
        this.nombre_comercial = nombre_comercial;
        this.direccion = direccion;
        this.telefono = telefono;
        this.estado = estado;
    }

    public EntidadEntity(Long id, String nro_documento, String razon_social, String nombre_comercial, String direccion, String telefono, Boolean estado, TipoDocumentoEntity tipoDocumento) {
        this.id = id;
        this.nro_documento = nro_documento;
        this.razon_social = razon_social;
        this.nombre_comercial = nombre_comercial;
        this.direccion = direccion;
        this.telefono = telefono;
        this.estado = estado;
        this.tipoDocumento = tipoDocumento;
    }

    public EntidadEntity(Long id, String nro_documento, String razon_social, String nombre_comercial, String direccion, String telefono, Boolean estado, TipoDocumentoEntity tipoDocumento, TipoContribuyenteEntity tipoContribuyente) {
        this.id = id;
        this.nro_documento = nro_documento;
        this.razon_social = razon_social;
        this.nombre_comercial = nombre_comercial;
        this.direccion = direccion;
        this.telefono = telefono;
        this.estado = estado;
        this.tipoDocumento = tipoDocumento;
        this.tipoContribuyente = tipoContribuyente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNro_documento() {
        return nro_documento;
    }

    public void setNro_documento(String nro_documento) {
        this.nro_documento = nro_documento;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getNombre_comercial() {
        return nombre_comercial;
    }

    public void setNombre_comercial(String nombre_comercial) {
        this.nombre_comercial = nombre_comercial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public TipoDocumentoEntity getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumentoEntity tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public TipoContribuyenteEntity getTipoContribuyente() {
        return tipoContribuyente;
    }

    public void setTipoContribuyente(TipoContribuyenteEntity tipoContribuyente) {
        this.tipoContribuyente = tipoContribuyente;
    }
}
