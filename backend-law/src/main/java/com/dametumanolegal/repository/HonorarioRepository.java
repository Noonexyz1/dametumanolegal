package com.dametumanolegal.repository;

import com.dametumanolegal.entities.Honorario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HonorarioRepository extends JpaRepository<Honorario, Long> {
}
