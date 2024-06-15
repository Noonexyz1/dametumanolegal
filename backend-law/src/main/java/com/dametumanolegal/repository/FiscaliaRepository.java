package com.dametumanolegal.repository;

import com.dametumanolegal.entities.Fiscalia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FiscaliaRepository extends JpaRepository<Fiscalia, Long> {
}
