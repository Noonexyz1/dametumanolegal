package com.dametumanolegal.repository;

import com.dametumanolegal.entities.Subsanacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubsanacionRepository extends JpaRepository<Subsanacion, Long> {
}
