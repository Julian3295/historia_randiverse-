package com.randiverse.historia_usario.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Long usuarioId;

    @Column(name = "nombre_usuario", nullable = false, unique = true)
    private String nombreUsuario;

    @Column(nullable = false, unique = true)
    private String email;

    private String descripcion;

    @Column(name = "verificado")
    private Boolean verificado;

    @Column(name = "foto_perfil")
    private String fotoPerfil;

    private Integer rango;
}
