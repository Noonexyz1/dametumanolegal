package com.dametumanolegal.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SesionResponse{
    private Long idSesion;
    private String fechaSesion;
    private boolean estadoSesion;

    private StaffLegalResponse fkStaffLegal;

    //No entiendo como sabe que idCuenta es el id (Long) de CuentaDomain cuando
    //CuentaDomain es un objeto o referencia o instancia, la cosa es que lo hace
    //parece modelMaper, la primera coincidencia de tipo Long, lo asigna, buscando de
    //un grado superior a un grado mas infercion, hasta que haga match
    //si hay dos valores con el mismo tipo, entonces por medio del tipo y nombre de variable
    /*private Long idCuenta;*/
}
