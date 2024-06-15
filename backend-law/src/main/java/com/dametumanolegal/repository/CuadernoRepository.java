package com.dametumanolegal.repository;

import com.dametumanolegal.entities.Cuaderno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuadernoRepository extends JpaRepository<Cuaderno, Long> {
}
