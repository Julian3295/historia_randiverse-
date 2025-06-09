package com.randiverse.historia_usuario.model;

import lombok.Data;
import jakarta.persistence.*; // Asegúrate de que esta línea esté presente

@Data
@Entity
@Table(name = "me_gustas") // Verifica que el nombre de la tabla sea correcto
public class MeGusta {

    @Id // <--- ¡ESTA ANOTACIÓN ES CRÍTICA!
    @GeneratedValue(strategy = GenerationType.IDENTITY) // <--- ¡Y ESTA TAMBIÉN!
    @Column(name = "id_me_gusta") // <--- Asegúrate que el nombre de la columna PK sea correcto en tu BD
    private Long idMeGusta; // <--- Y que este sea el campo PK

    @ManyToOne
    @JoinColumn(name = "publicacion_id", nullable = false) // FK a publicaciones
    private Publicacion publicacion;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false) // FK a usuarios
    private Usuario usuario;

    // Si tu tabla me_gustas tiene una columna para la fecha, agrégala aquí:
    // @Column(name = "fecha_like")
    // private LocalDateTime fechaLike;
}