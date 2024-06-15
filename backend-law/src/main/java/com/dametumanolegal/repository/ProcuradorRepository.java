package com.dametumanolegal.repository;

import com.dametumanolegal.entities.Procurador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcuradorRepository extends JpaRepository<Procurador, Long> {
}
