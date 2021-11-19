package com.nyobyte.pruebatecnica.model.dto;

public class EntidadDTO {
    private Long id;
    private String nro_documento;
    private String razon_social;
    private String nombre_comercial;
    private String direccion;
    private String telefono;
    private Boolean estado;
    private Long tipoDocumento_id;
    private Long tipoContribuyente_id;

    public EntidadDTO(Long id, String nro_documento, String razon_social, String nombre_comercial, String direccion, String telefono, Boolean estado, Long tipoDocumento_id, Long tipoContribuyente_id) {
        this.id = id;
        this.nro_documento = nro_documento;
        this.razon_social = razon_social;
        this.nombre_comercial = nombre_comercial;
        this.direccion = direccion;
        this.telefono = telefono;
        this.estado = estado;
        this.tipoDocumento_id = tipoDocumento_id;
        this.tipoContribuyente_id = tipoContribuyente_id;
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

    public Long getTipoDocumento_id() {
        return tipoDocumento_id;
    }

    public void setTipoDocumento_id(Long tipoDocumento_id) {
        this.tipoDocumento_id = tipoDocumento_id;
    }

    public Long getTipoContribuyente_id() {
        return tipoContribuyente_id;
    }

    public void setTipoContribuyente_id(Long tipoContribuyente_id) {
        this.tipoContribuyente_id = tipoContribuyente_id;
    }
}
