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
@Table(name = "juez")
public class Juez {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @ManyToOne
    //@JoinColumn(name = "figura_legal_id")
    private FiguraLegal fkFigLegal;

    @ManyToOne
    private Juzgado fkJuzgado;

    @OneToMany(mappedBy = "fkJuez")
    private List<ProcesoJuzgado> listaProcesosJuzgado;

}
