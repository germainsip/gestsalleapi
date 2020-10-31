package org.gerblog.gestsalleapi.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idSalle;

    private String nomSalle;
    @Enumerated(EnumType.STRING)
    private TypeSalle type;
    private Batiment batiment;
    @OneToMany(mappedBy = "salle")
    private List<Poste> postes;



}
