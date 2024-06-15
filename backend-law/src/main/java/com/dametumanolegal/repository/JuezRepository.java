package com.dametumanolegal.repository;

import com.dametumanolegal.entities.Juez;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JuezRepository extends JpaRepository<Juez, Long> {
}
