package com.dametumanolegal.repository;

import com.dametumanolegal.entities.Fiscal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FiscalRepository extends JpaRepository<Fiscal, Long> {
}
