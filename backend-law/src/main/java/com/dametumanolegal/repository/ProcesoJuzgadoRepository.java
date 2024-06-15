package com.dametumanolegal.repository;

import com.dametumanolegal.entities.ProcesoJuzgado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcesoJuzgadoRepository extends JpaRepository<ProcesoJuzgado, Long> {
}
