package org.gerblog.gestsalleapi.repository;

import org.gerblog.gestsalleapi.model.Poste;
import org.gerblog.gestsalleapi.model.Salle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PosteRepository  extends JpaRepository<Poste,Long> {
    List<Poste> findAllBySalle(Salle salle);
}
