package com.dametumanolegal.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentacionDomain {
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
