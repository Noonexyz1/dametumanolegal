package com.dametumanolegal.repository;

import com.dametumanolegal.entities.ArchivoCaso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArchivoCasoRepository extends JpaRepository<ArchivoCaso, Long> {
}
