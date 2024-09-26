package tn.esprit.tpfoyer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Etudiant;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.entity.Universite;
import tn.esprit.tpfoyer.repository.EtudiantReposirory;
import tn.esprit.tpfoyer.repository.ReservationRepository;

import java.util.Date;
import java.util.List;
@Service
@AllArgsConstructor
public class ReservationServiceImpl implements IReservationService {

    ReservationRepository reservationRepository;
    EtudiantReposirory etudiantReposirory;
    public List<Reservation> retrieveAllReservations() {
        return reservationRepository.findAll();
    }
    public Reservation retrieveReservations(String idReservation) {
        return reservationRepository.findById(idReservation).orElse(null);
    }
    public Reservation addReservations(Reservation c) {
        return reservationRepository.save(c);
    }
    public void removeReservations(String idReservation) {
        reservationRepository.deleteById(idReservation);
    }
    public Reservation modifyReservations(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public void assignfoyerTouniversite(String idReservation, Long idEtudiant){
        Reservation reservation = reservationRepository.findById(idReservation).get();
        Etudiant etudiant = etudiantReposirory.findById(idEtudiant).get();
// on set le fils dans le parent :
        reservation.getEtudiants().add(etudiant);
        reservationRepository.save(reservation);
    }

    public void unassignfoyerTouniversite(String idReservation,Long idEtudiant){
        Reservation reservation  = reservationRepository.findById(idReservation).get();
        Etudiant etudiant = etudiantReposirory.findById(idEtudiant).get();

// on deaffect le fils dans le parent :
        reservation.getEtudiants().add(etudiant);
        reservationRepository.save(reservation);
    }
    public Reservation adduniversiteAndassignfoyerTouniversite(Reservation reservation, Long idEtudiant){
        Etudiant etudiant = etudiantReposirory.findById(idEtudiant).get();
// on set le fils dans le parent :
        reservation.getEtudiants().add(etudiant);
        return reservationRepository.save(reservation);




    }

    public  List<Reservation> trouverresrevationselondateetstatus( Date d, boolean validite){


        return reservationRepository.findAllByAnneeUniversiteBeforeAndEstValideIs(d,validite);

    }




}
