package com.dametumanolegal.domain;

import com.dametumanolegal.entities.Documentacion;
import com.dametumanolegal.entities.Tramite;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArchivoTramiteDomain {
    private Long id;
    private String numeroTramite; // Número de identificación del caso
    private String descripcion; // Descripción del caso
    private String direccionFisica; // Dirección física donde se guarda el archivo (e.g., vagón, estante)
    private String fechaCreacion; // Fecha de creación del archivo del caso
    private String responsable; // Persona responsable del archivo del caso


    private Documentacion fkDocu;
    private Tramite fkTramite;

}
