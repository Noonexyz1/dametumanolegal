package com.dametumanolegal.dtos.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotificacionResponse {
    private Long id;
    private String tipo;
    private String fecha;
    private String contenido;
}
