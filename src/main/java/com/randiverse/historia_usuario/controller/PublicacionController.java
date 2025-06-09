package com.randiverse.historia_usuario.controller;

import com.randiverse.historia_usuario.dto.StandardResponse;
import com.randiverse.historia_usuario.dto.PublicacionExtendidaDTO; // Importa el DTO extendido
import com.randiverse.historia_usuario.model.Publicacion;
import com.randiverse.historia_usuario.service.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publicaciones")
public class PublicacionController {

    @Autowired
    private PublicacionService publicacionService;

    @PostMapping
    public ResponseEntity<StandardResponse> crearPublicacion(@RequestBody PublicacionRequest publicacionRequest) {
        try {
            Publicacion nuevaPublicacion = publicacionService.crearPublicacion(publicacionRequest);
            return new ResponseEntity<>(
                new StandardResponse(true, nuevaPublicacion), // Usa 'true' y 'nuevaPublicacion'
                HttpStatus.CREATED
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                new StandardResponse(false, "Error al crear la publicación: " + e.getMessage()),
                HttpStatus.BAD_REQUEST
            );
        }
    }

    @GetMapping // Este endpoint sigue devolviendo la entidad Publicacion completa
    public ResponseEntity<StandardResponse> obtenerTodasLasPublicaciones() {
        try {
            Iterable<Publicacion> publicaciones = publicacionService.obtenerTodasLasPublicaciones();
            return new ResponseEntity<>(
                new StandardResponse(true, publicaciones), // Usa 'true' y 'publicaciones'
                HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                new StandardResponse(false, "Error al obtener las publicaciones: " + e.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    // NUEVO ENDPOINT PARA LA CONSULTA EXTENDIDA CON LIKES
    @GetMapping("/con-creador-y-likes") // Un nuevo path específico
    public ResponseEntity<StandardResponse> obtenerPublicacionesConCreadorYLikes() {
        try {
            List<PublicacionExtendidaDTO> publicaciones = publicacionService.obtenerPublicacionesConCreadorYLikes();
            return new ResponseEntity<>(
                new StandardResponse(true, publicaciones), // Envuelve la lista de DTOs en StandardResponse
                HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                new StandardResponse(false, "Error al obtener publicaciones con creador y likes: " + e.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
}