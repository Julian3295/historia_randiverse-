package com.randiverse.historia_usuario.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Data
public class PublicacionRequest {

    @NotNull(message = "El ID de usuario no puede ser nulo")
    private Long usuarioCreadorId;

    @NotBlank(message = "El nombre de la publicación es obligatorio")
    @Size(max = 255, message = "El nombre de la publicación no puede exceder los 255 caracteres")
    private String nombrePublicacion;

    @NotBlank(message = "El contenido de la publicación es obligatorio")
    private String contenidoPublicacion;

    @Size(max = 500, message = "La descripción no puede exceder los 500 caracteres")
    private String descripcionPublicacion;

    private String portadaPublicacion;

    private Boolean visibilidadPublicacion;
}