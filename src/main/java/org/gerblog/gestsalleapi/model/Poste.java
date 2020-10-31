package org.gerblog.gestsalleapi.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Poste {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String numPoste;
    private String numIlot;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_salle")
    private Salle salle;
    //TODO: est ce qu'on rajoute la chaise dans la liste?
}
