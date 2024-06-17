package com.dametumanolegal.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FiscalResponse {
    private Long id;

    private FiguraLegalResponse fkFigLegal;
    private FiscaliaResponse fkFiscalia;
}
