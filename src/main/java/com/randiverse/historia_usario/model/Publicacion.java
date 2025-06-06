package com.randiverse.historia_usario.model; // Asegúrate de que el paquete sea correcto

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime; // Para el tipo datetime

@Entity
@Table(name = "publicaciones")
@Data
public class Publicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pub_id")
    private Long pubId; // bigint en BD

    // Relación con Usuario (usuario_creador)
    @ManyToOne // Muchas publicaciones pueden ser creadas por un usuario
    @JoinColumn(name = "usuario_creador", nullable = false) // Columna FK en esta tabla (publicaciones)
    private Usuario usuarioCreador; // bigint en BD, mapeado a la entidad Usuario

    @Column(name = "nombre_publicacion", nullable = false)
    private String nombrePublicacion; // varchar en BD

    @Column(name = "descripcion_publicacion")
    private String descripcionPublicacion; // varchar en BD

    @Column(name = "contenido_publicacion", columnDefinition = "TEXT", nullable = false) // Usa TEXT para contenido largo
    private String contenidoPublicacion; // text en BD

    @Column(name = "portada_publicacion")
    private String portadaPublicacion; // varchar en BD (URL de la imagen de portada)

    @Column(name = "fecha_publicacion", nullable = false)
    private LocalDateTime fechaPublicacion; // datetime en BD

    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion; // datetime en BD

    @Column(name = "visibilidad_publicacion")
    private Boolean visibilidadPublicacion; // binary en BD (usamos Boolean en Java)

    // Nota: Las relaciones con comentarios, likes, favoritos se agregarán más adelante
    // para mantenerlo sencillo por ahora.
}
