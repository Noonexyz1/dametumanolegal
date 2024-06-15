package com.dametumanolegal.repository;

import com.dametumanolegal.entities.CasoFiscalia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CasoFiscaliaRepository extends JpaRepository<CasoFiscalia, Long> {
}
