package com.randiverse.historia_usuario.controller;

import com.randiverse.historia_usuario.dto.PublicacionRequest;
import com.randiverse.historia_usuario.model.Publicacion;
import com.randiverse.historia_usuario.service.PublicacionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/publicaciones")
public class PublicacionController {

    private final PublicacionService publicacionService;

    public PublicacionController(PublicacionService publicacionService) {
        this.publicacionService = publicacionService;
    }

    @PostMapping
    public ResponseEntity<?> crearPublicacion(@Valid @RequestBody PublicacionRequest request) {
        try {
            Publicacion nuevaPublicacion = publicacionService.crearPublicacion(request);
            // Esto devuelve la Publicacion directamente. No cumple con el formato de respuesta JSON que te pidió tu amigo.
            return new ResponseEntity<>(nuevaPublicacion, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Error: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error interno del servidor.");
        }
    }
}