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
@Table(name = "notificacion")
public class Notificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @OneToMany(mappedBy = "fkNotificacion")
    private List<ProcesoFiscal> listaProcesosFiscal;
    @OneToMany(mappedBy = "fkNotificacion")
    private List<ProcesoJuzgado> listaProcesosJuzgado;

}
