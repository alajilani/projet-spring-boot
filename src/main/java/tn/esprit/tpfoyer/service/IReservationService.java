package tn.esprit.tpfoyer.service;

import tn.esprit.tpfoyer.entity.Reservation;

import java.util.Date;
import java.util.List;

public interface IReservationService {


    public  List<Reservation> trouverresrevationselondateetstatus(Date d, boolean validite);
    public List<Reservation> retrieveAllReservations();
    public Reservation retrieveReservations(String idReservation);
    public Reservation addReservations(Reservation c);
    public void removeReservations(String idUniversite);
    public Reservation modifyReservations(Reservation reservation);

    public void assignfoyerTouniversite(String idReservation, Long idEtudiant);
    public void unassignfoyerTouniversite(String idReservation,Long idEtudiant);
    public Reservation adduniversiteAndassignfoyerTouniversite(Reservation reservation, Long idEtudiant);
// Here we will add later methods calling keywords and methods calling JPQL
}
