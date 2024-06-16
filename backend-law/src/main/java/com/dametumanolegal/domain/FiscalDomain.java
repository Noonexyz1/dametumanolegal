package com.dametumanolegal.domain;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FiscalDomain {
    private Long id;

    private FiguraLegalDomain fkFigLegal;

    private FiscaliaDomain fkFiscalia;
}
