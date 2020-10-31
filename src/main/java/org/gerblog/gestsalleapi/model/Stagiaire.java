package org.gerblog.gestsalleapi.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Stagiaire {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idStagiaire;
    private String  nom;
    private String prenom;
    private String offre;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="uc_id")
    private Uc uc;
    private Instant debut;
    private Instant fin;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "poste_id")
    private Poste poste;
}
