package com.randiverse.historia_usuario.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreadorPublicacionDTO {
    private Long usuarioId;
    private String nombreUsuario;
}