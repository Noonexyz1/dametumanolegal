package com.dametumanolegal.repository;

import com.dametumanolegal.entities.StaffLegal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffLegalRepository extends JpaRepository<StaffLegal, Long> {
}
