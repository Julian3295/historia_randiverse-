package com.randiverse.historia_usuario.service;

import com.randiverse.historia_usuario.model.Publicacion;
import com.randiverse.historia_usuario.controller.PublicacionRequest;
import com.randiverse.historia_usuario.dto.PublicacionExtendidaDTO;
import com.randiverse.historia_usuario.model.Usuario;
import com.randiverse.historia_usuario.repository.PublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional; // Importa Optional para findById

@Service
public class PublicacionService {

    @Autowired
    private PublicacionRepository publicacionRepository;

    // Método para crear una publicación
    public Publicacion crearPublicacion(PublicacionRequest publicacionRequest) {
        // Busca el usuario creador por su ID
        Optional<Usuario> optionalUsuario = Optional.empty();

        // Si el usuario no se encuentra, lanza una excepción
        Usuario usuarioCreador = optionalUsuario.orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + publicacionRequest.getUsuarioCreadorID()));

        Publicacion publicacion = new Publicacion();
        publicacion.setUsuarioCreador(usuarioCreador);
        publicacion.setNombrePublicacion(publicacionRequest.getNombrePublicacion());
        publicacion.setContenidoPublicacion(publicacionRequest.getNombrePublicacion());
        publicacion.setDescripcionPublicacion(publicacionRequest.getNombrePublicacion());
        publicacion.setPortadaPublicacion(publicacionRequest.getNombrePublicacion());
        // Aquí usamos getVisibilidadPublicacion() porque ya ajustamos PublicacionRequest a Boolean
        publicacion.setContenidoPublicacion(publicacionRequest.getNombrePublicacion());
        publicacion.setFechaPublicacion(LocalDateTime.now());
        publicacion.setFechaActualizacion(LocalDateTime.now());

        return publicacionRepository.save(publicacion);
    }

    // Método para obtener todas las publicaciones (entidades completas)
    public Iterable<Publicacion> obtenerTodasLasPublicaciones() {
        return publicacionRepository.findAll();
    }

    // Método para obtener publicaciones con datos extendidos (incluyendo creador y conteo de likes)
    public List<PublicacionExtendidaDTO> obtenerPublicacionesConCreadorYLikes() {
        return publicacionRepository.findAllPublicacionesConCreadorAndLikes();
    }
}