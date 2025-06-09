package com.randiverse.historia_usuario.controller;

public class PublicacionRequest {
    private Long usuarioCreadorID;
    private String nombrePublicacion;

    public Long getUsuarioCreadorID() {
        return usuarioCreadorID;
    }

    public void setUsuarioCreadorID(Long usuarioCreadorID) {
        this.usuarioCreadorID = usuarioCreadorID;
    }

    public String getNombrePublicacion() {
        return nombrePublicacion;
    }

    public void setNombrePublicacion(String nombrePublicacion) {
        this.nombrePublicacion = nombrePublicacion;
    }
}