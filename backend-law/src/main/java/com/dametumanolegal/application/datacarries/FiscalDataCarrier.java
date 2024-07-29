package com.dametumanolegal.application.datacarries;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FiscalDataCarrier {
    private Long id;

    private FiguraLegalDataCarrier fkFigLegal;

    private FiscaliaDataCarrier fkFiscalia;
}
