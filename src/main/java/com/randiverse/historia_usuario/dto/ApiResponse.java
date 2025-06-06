package com.randiverse.historia_usuario.dto; // Asegúrate de que el paquete sea correcto

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data // Genera getters, setters, toString, equals, hashCode
@AllArgsConstructor // Genera un constructor con todos los argumentos
@NoArgsConstructor // Genera un constructor sin argumentos
public class ApiResponse<T> { // <T> indica que es una clase genérica

    private Boolean estado; // Corresponde a "Estado" en tu formato
    private T respuesta;    // Corresponde a "Respuesta", puede ser datos o mensajes

    // Método estático para crear una respuesta exitosa
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(true, data); // Estado true, con los datos
    }

    // Método estático para crear una respuesta de error
    public static <T> ApiResponse<T> error(T errorMessage) {
        return new ApiResponse<>(false, errorMessage); // Estado false, con el mensaje de error
    }
}