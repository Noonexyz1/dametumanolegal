package com.dametumanolegal.repository;

import com.dametumanolegal.entities.Ito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItoRepository extends JpaRepository<Ito, Long> {
}
