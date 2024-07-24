package com.dametumanolegal.infrastructure.persistence.repository;

import com.dametumanolegal.infrastructure.persistence.entities.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
    @Query(value = "SELECT * FROM cuenta WHERE ci_usuario = :usuario AND pass_usuario = :contrasena", nativeQuery = true)
    Optional<Cuenta> findByUsuarioAndContrasena(@Param("usuario") String usuario, @Param("contrasena") String contrasena);
}
