package com.dametumanolegal.repository;

import com.dametumanolegal.entities.ArchivoTramite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArchivoTramiteRepository extends JpaRepository<ArchivoTramite, Long> {
}
