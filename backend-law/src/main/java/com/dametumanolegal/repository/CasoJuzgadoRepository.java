package com.dametumanolegal.repository;

import com.dametumanolegal.entities.CasoJuzgado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CasoJuzgadoRepository extends JpaRepository<CasoJuzgado, Long> {
}
