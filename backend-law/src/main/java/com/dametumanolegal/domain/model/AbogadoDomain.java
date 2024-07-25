package com.dametumanolegal.domain.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AbogadoDomain extends StaffLegalDomain {
    private Long idAbogado;
    private boolean isAdmin;

    public AbogadoDomain(Long idFiguraLegal, String nombres, String apellidos, String ci, String direccion, String telefono, String email, String rol, String fechaNacimiento, String genero, String fechaRegistro, boolean isActive, Long idStaffLegal, Long idAbogado, boolean isAdmin){
        super(idFiguraLegal, nombres, apellidos, ci, direccion, telefono, email, rol, fechaNacimiento, genero, fechaRegistro, isActive, idStaffLegal);
        this.idAbogado = idAbogado;
        this.isAdmin = isAdmin;
    }
}
