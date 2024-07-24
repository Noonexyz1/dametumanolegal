package com.dametumanolegal.domain.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CasoJuzgadoDomain {
    private Long id;

    private CasoDomain fkCaso;
}
