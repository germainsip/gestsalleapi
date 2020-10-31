package org.gerblog.gestsalleapi.repository;

import org.gerblog.gestsalleapi.model.Salle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalleRepository  extends JpaRepository<Salle,Long> {
    List<Salle> findAllByBatiment(String batiment);
}
