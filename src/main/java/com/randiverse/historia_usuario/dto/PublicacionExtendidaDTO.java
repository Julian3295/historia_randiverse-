package com.randiverse.historia_usuario.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor // Asegúrate de que este constructor tenga todos los campos, incluyendo numLikes
@NoArgsConstructor
public class PublicacionExtendidaDTO {

    private Long pubId;
    private String nombrePublicacion;
    private String contenidoPublicacion;
    private String descripcionPublicacion;
    private String portadaPublicacion;
    private LocalDateTime fechaPublicacion;
    private LocalDateTime fechaActualizacion;
    private Boolean visibilidadPublicacion; // Usar Boolean para que coincida con la entidad

    private CreadorPublicacionDTO usuarioCreador; // El sub-objeto para el creador

    private Long numLikes; // <--- ¡NUEVO CAMPO PARA EL CONTEO DE LIKES!
}
