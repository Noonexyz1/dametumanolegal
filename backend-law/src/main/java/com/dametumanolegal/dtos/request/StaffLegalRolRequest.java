package com.dametumanolegal.dtos.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StaffLegalRolRequest {
    private Long idPersonal;
    private Long idRol;
}
