package com.dametumanolegal.infrastructure.persistence.repository;

import com.dametumanolegal.infrastructure.persistence.entities.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {
}
