package com.dametumanolegal.application.datacarries;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProcuradorDataCarrier extends StaffLegalDataCarrier {
    private Long idProcurador;

    public ProcuradorDataCarrier(Long idFiguraLegal, String nombres, String apellidos, String ci, String direccion, String telefono, String email, String rol, String fechaNacimiento, String genero, String fechaRegistro, boolean isActive, Long idStaffLegal, Long idProcurador){
        //Antes super(id, nombres, apellidos, ci, direccion, telefono, email, rol, fechaNacimiento, genero, fechaRegistro, isActive);
        //Ahora
        super(idFiguraLegal, nombres, apellidos, ci, direccion, telefono, email, rol, fechaNacimiento, genero, fechaRegistro, isActive, idStaffLegal);
        this.idProcurador = idProcurador;
    }
}
