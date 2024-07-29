package com.dametumanolegal.application.datacarries;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDataCarrier extends StaffLegalDataCarrier {
    private Long idCliente;

    public ClienteDataCarrier(Long idFiguraLegal, String nombres, String apellidos, String ci, String direccion, String telefono, String email, String rol, String fechaNacimiento, String genero, String fechaRegistro, boolean isActive, Long idStaffLegal, Long idCliente){
        super(idFiguraLegal, nombres, apellidos, ci, direccion, telefono, email, rol, fechaNacimiento, genero, fechaRegistro, isActive, idStaffLegal);
        this.idCliente = idCliente;
    }
}
