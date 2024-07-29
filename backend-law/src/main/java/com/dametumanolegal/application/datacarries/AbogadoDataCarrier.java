package com.dametumanolegal.application.datacarries;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AbogadoDataCarrier extends StaffLegalDataCarrier {
    private Long idAbogado;
    private boolean isAdmin;

    public AbogadoDataCarrier(Long idFiguraLegal, String nombres, String apellidos, String ci, String direccion, String telefono, String email, String rol, String fechaNacimiento, String genero, String fechaRegistro, boolean isActive, Long idStaffLegal, Long idAbogado, boolean isAdmin){
        super(idFiguraLegal, nombres, apellidos, ci, direccion, telefono, email, rol, fechaNacimiento, genero, fechaRegistro, isActive, idStaffLegal);
        this.idAbogado = idAbogado;
        this.isAdmin = isAdmin;
    }
}
