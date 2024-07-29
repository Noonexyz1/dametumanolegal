package com.dametumanolegal.application.datacarries;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CuentaDataCarrier {
    private Long id;
    private String ciUsuario;
    private String passUsuario;
    private boolean isActive;

    private StaffLegalDataCarrier fkStaffLegal;
}
