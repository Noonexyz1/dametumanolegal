package com.dametumanolegal.application.datacarries;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActuadoDataCarrier {
    private Long id;
    private String tipo; // Tipo de actuado (e.g., demanda, resolución, notificación)
    private String descripcion; // Descripción detallada del actuado
    private String fechaCreacion; // Fecha en que se creó el actuado
    private String creador; // Persona o entidad que creó el actuado
    private String contenido; // Contenido del actuado (puede ser el texto del documento)


    private CasoDataCarrier fkCaso;
}
