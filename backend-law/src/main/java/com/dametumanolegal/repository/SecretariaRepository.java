package com.dametumanolegal.repository;

import com.dametumanolegal.entities.Secretaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecretariaRepository extends JpaRepository<Secretaria, Long> {
}
