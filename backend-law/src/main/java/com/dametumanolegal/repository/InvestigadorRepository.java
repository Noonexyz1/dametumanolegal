package com.dametumanolegal.repository;

import com.dametumanolegal.entities.Investigador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestigadorRepository extends JpaRepository<Investigador, Long> {
}
