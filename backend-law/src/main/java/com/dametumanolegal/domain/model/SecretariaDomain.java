package com.dametumanolegal.domain.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SecretariaDomain extends StaffLegalDomain {
    private Long idSecretaria;

    public SecretariaDomain(Long idFiguraLegal, String nombres, String apellidos, String ci, String direccion, String telefono, String email, String rol, String fechaNacimiento, String genero, String fechaRegistro, boolean isActive, Long idStaffLegal, Long idSecretaria){
        super(idFiguraLegal, nombres, apellidos, ci, direccion, telefono, email, rol, fechaNacimiento, genero, fechaRegistro, isActive, idStaffLegal);
        this.idSecretaria = idSecretaria;
    }
}
