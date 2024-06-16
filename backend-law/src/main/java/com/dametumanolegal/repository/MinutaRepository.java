package com.dametumanolegal.repository;

import com.dametumanolegal.entities.Minuta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MinutaRepository extends JpaRepository<Minuta, Long> {
}
