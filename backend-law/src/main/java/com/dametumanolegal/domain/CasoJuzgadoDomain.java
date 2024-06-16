package com.dametumanolegal.domain;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CasoJuzgadoDomain {
    private Long id;

    private CasoDomain fkCaso;
}
