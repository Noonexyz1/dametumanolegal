package com.dametumanolegal.repository;

import com.dametumanolegal.entities.FiguraLegal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FiguraLegalRepository extends JpaRepository<FiguraLegal, Long> {
}
