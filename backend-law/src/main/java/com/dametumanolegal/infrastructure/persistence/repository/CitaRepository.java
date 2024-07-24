package com.dametumanolegal.infrastructure.persistence.repository;

import com.dametumanolegal.infrastructure.persistence.entities.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {
}
