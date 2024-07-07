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
}
