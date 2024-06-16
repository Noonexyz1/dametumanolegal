package com.dametumanolegal.dtos.request;

import com.dametumanolegal.dtos.response.FiguraLegalResponse;
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

    private FiguraLegalResponse fkFigLegalDomain;
}
