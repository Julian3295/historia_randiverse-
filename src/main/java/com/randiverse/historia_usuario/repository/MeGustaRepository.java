package com.randiverse.historia_usuario.repository;

import com.randiverse.historia_usuario.model.MeGusta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeGustaRepository extends JpaRepository<MeGusta, Long> {
    // Puedes añadir métodos específicos si los necesitas, como:
    // Long countByPublicacionPubId(Long publicacionId);
}