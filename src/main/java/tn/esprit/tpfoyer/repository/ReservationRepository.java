package tn.esprit.tpfoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.entity.TypeChambre;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,String> {

    List<Reservation> findAllByAnneeUniversiteBeforeAndEstValideIs(Date anneuniv,boolean validite);
}
