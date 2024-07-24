package com.dametumanolegal.domain.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDomain extends StaffLegalDomain {
    private Long idCliente;

    public ClienteDomain(Long idFiguraLegal, String nombres, String apellidos, String ci, String direccion, String telefono, String email, String rol, String fechaNacimiento, String genero, String fechaRegistro, boolean isActive, Long idStaffLegal, Long idCliente){
        super(idFiguraLegal, nombres, apellidos, ci, direccion, telefono, email, rol, fechaNacimiento, genero, fechaRegistro, isActive, idStaffLegal);
        this.idCliente = idCliente;
    }
}
