package com.dametumanolegal.domain.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CasoFiscaliaDomain {
    private Long id;

    private CasoDomain fkCaso;

}
