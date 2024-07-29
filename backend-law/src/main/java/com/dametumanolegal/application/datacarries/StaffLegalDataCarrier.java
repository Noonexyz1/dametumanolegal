package com.dametumanolegal.application.datacarries;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffLegalDataCarrier extends FiguraLegalDataCarrier {
    private Long id;

    public StaffLegalDataCarrier(Long id, String nombres, String apellidos, String ci, String direccion, String telefono, String email, String rol, String fechaNacimiento, String genero, String fechaRegistro, boolean isActive, Long idStaffLegal){
        super(id, nombres, apellidos, ci, direccion, telefono, email, rol, fechaNacimiento, genero, fechaRegistro, isActive);
        this.id = idStaffLegal;
    }
}