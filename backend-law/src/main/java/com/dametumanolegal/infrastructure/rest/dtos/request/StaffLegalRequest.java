package com.dametumanolegal.infrastructure.rest.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StaffLegalRequest {
    private Long idStaffLegal;

    private FiguraLegalRequest fkFigLegalDomain;
}
