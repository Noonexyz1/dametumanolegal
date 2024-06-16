package com.dametumanolegal.repository;

import com.dametumanolegal.entities.Tramite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TramiteRepository extends JpaRepository<Tramite, Long> {
}
