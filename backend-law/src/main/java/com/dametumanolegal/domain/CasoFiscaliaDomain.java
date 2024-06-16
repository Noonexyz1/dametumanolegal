package com.dametumanolegal.domain;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CasoFiscaliaDomain {
    private Long id;

    private CasoDomain fkCaso;

}
