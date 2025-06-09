package com.randiverse.historia_usuario.repository;

import com.randiverse.historia_usuario.model.Publicacion;
import com.randiverse.historia_usuario.dto.PublicacionExtendidaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicacionRepository extends JpaRepository<Publicacion, Long> {

    @Query("SELECT new com.randiverse.historia_usuario.dto.PublicacionExtendidaDTO(" +
           "p.pubId, p.nombrePublicacion, p.contenidoPublicacion, p.descripcionPublicacion, " +
           "p.portadaPublicacion, p.fechaPublicacion, p.fechaActualizacion, p.visibilidadPublicacion, " +
           "new com.randiverse.historia_usuario.dto.CreadorPublicacionDTO(u.usuarioId, u.nombreUsuario), " +
           "COUNT(l.idMeGusta)) " + // Conteo de likes
           "FROM Publicacion p " +
           "JOIN p.usuarioCreador u " + // Unión con la entidad Usuario a través de la relación en Publicacion
           "LEFT JOIN MeGusta l ON l.publicacion = p " + // LEFT JOIN con la entidad MeGusta
           "GROUP BY p.pubId, p.nombrePublicacion, p.contenidoPublicacion, p.descripcionPublicacion, " +
           "p.portadaPublicacion, p.fechaPublicacion, p.fechaActualizacion, p.visibilidadPublicacion, " +
           "u.usuarioId, u.nombreUsuario") // Agrupar por todos los campos seleccionados (excepto el COUNT)
    List<PublicacionExtendidaDTO> findAllPublicacionesConCreadorAndLikes(); // Nombre de método claro

    // Puedes mantener otros métodos JpaRepository como findById, save, etc.
    // También puedes mantener tu método anterior obtenerTodasLasPublicaciones() si lo necesitas para otras llamadas.
}