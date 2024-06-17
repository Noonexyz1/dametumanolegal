package com.dametumanolegal.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DocumentacionResponse {
    private Long id;

    private String nombre;
    private String tipoCaso;
    private boolean isDocumentoInicial;
    private String fechaCreacion;
    private String fechaUltimaActualizacion;
    private String estado;
    private String descripcion;
    private String responsable; // Persona o entidad responsable del documento
    private String observaciones;
}
