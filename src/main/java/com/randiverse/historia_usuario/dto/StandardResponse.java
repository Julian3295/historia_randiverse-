package com.randiverse.historia_usuario.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandardResponse {
    private Boolean ok; // 'estado' cambiado a 'ok'
    private Object Response; // 'respuesta' cambiado a 'Response'
}