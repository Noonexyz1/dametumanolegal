package com.dametumanolegal.infrastructure.persistence.repository;

import com.dametumanolegal.infrastructure.persistence.entities.Documentacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentancionRepository extends JpaRepository<Documentacion, Long> {
}
