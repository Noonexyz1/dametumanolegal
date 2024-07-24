package com.dametumanolegal.infrastructure.persistence.repository;

import com.dametumanolegal.infrastructure.persistence.entities.Juzgado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JuzgadoRepository extends JpaRepository<Juzgado, Long> {
}
