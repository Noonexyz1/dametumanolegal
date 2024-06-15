package com.dametumanolegal.repository;

import com.dametumanolegal.entities.Abogado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbogadoRepository extends JpaRepository<Abogado, Long> {
}
