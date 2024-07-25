package com.dametumanolegal.domain.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffLegalDomain extends FiguraLegalDomain {
    private Long id;

    public StaffLegalDomain(Long id, String nombres, String apellidos, String ci, String direccion, String telefono, String email, String rol, String fechaNacimiento, String genero, String fechaRegistro, boolean isActive, Long idStaffLegal){
        super(id, nombres, apellidos, ci, direccion, telefono, email, rol, fechaNacimiento, genero, fechaRegistro, isActive);
        this.id = idStaffLegal;
    }
}