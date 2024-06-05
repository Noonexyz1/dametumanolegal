package com.dametumanolegal.repository;

import com.dametumanolegal.entities.Sesion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SesionRepository extends JpaRepository<Sesion, Long> {
}
