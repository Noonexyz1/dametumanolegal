package com.dametumanolegal.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "documentacion")
public class Documentacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
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


    @OneToMany(mappedBy = "fkDocu")
    private List<ArchivoCaso> listaArchivoCasos;

    @OneToMany(mappedBy = "fkDocu")
    private List<ArchivoTramite> listaArchivoTrami;
}
