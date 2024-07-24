package com.dametumanolegal.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificacionDomain {
    private Long id;
    private String tipo;
    private String fecha;
    private String contenido;
}
