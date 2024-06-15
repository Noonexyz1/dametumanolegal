package com.dametumanolegal.repository;

import com.dametumanolegal.entities.Juzgado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JuzgadoRepository extends JpaRepository<Juzgado, Long> {
}
