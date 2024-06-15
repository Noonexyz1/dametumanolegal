package com.dametumanolegal.repository;

import com.dametumanolegal.entities.ProcesoFiscal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcesoFiscalRepository extends JpaRepository<ProcesoFiscal, Long> {
}
