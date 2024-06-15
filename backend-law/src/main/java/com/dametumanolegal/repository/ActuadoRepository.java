package com.dametumanolegal.repository;

import com.dametumanolegal.entities.Actuado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActuadoRepository extends JpaRepository<Actuado, Long> {
}
