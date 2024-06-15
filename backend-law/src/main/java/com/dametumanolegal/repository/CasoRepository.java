package com.dametumanolegal.repository;

import com.dametumanolegal.entities.Caso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CasoRepository extends JpaRepository<Caso, Long> {
}
