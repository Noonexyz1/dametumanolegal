package com.dametumanolegal.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FiguraLegalResponse {
    private Long id;
    private String nombres;
    private String apellidos;
    private String ci;
    private boolean isActive;
}
