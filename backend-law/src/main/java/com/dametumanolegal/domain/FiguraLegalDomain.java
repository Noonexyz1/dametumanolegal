package com.dametumanolegal.domain;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FiguraLegalDomain {
    private Long id;
    private String nombres;
    private String apellidos;
    private String ci;
    private boolean isActive;
}
