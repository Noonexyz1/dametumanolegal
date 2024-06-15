package com.dametumanolegal.repository;

import com.dametumanolegal.entities.Documentacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentancionRepository extends JpaRepository<Documentacion, Long> {
}
