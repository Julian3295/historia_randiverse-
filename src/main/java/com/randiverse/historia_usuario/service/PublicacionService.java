package com.randiverse.historia_usuario.service;

import com.randiverse.historia_usuario.dto.PublicacionRequest;
import com.randiverse.historia_usuario.model.Publicacion;
import com.randiverse.historia_usuario.model.Usuario;
import com.randiverse.historia_usuario.repository.PublicacionRepository;
import com.randiverse.historia_usuario.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PublicacionService {

    private final PublicacionRepository publicacionRepository;
    private final UsuarioRepository usuarioRepository;

    public PublicacionService(PublicacionRepository publicacionRepository, UsuarioRepository usuarioRepository) {
        this.publicacionRepository = publicacionRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Publicacion crearPublicacion(PublicacionRequest request) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(request.getUsuarioCreadorId());
        if (usuarioOptional.isEmpty()) {
            throw new RuntimeException("Usuario creador con ID " + request.getUsuarioCreadorId() + " no encontrado.");
        }
        Usuario usuarioCreador = usuarioOptional.get();

        Publicacion publicacion = new Publicacion();
        publicacion.setNombrePublicacion(request.getNombrePublicacion());
        publicacion.setContenidoPublicacion(request.getContenidoPublicacion());
        publicacion.setDescripcionPublicacion(request.getDescripcionPublicacion());
        publicacion.setPortadaPublicacion(request.getPortadaPublicacion());
        publicacion.setVisibilidadPublicacion(request.getVisibilidadPublicacion() != null ? request.getVisibilidadPublicacion() : true);

        publicacion.setUsuarioCreador(usuarioCreador);
        publicacion.setFechaPublicacion(LocalDateTime.now());
        publicacion.setFechaActualizacion(LocalDateTime.now());

        return publicacionRepository.save(publicacion);
    }
}