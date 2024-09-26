package tn.esprit.tpfoyer.control;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Reservation;


import tn.esprit.tpfoyer.service.IReservationService;


import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
@RestController
@AllArgsConstructor
@RequestMapping("/reservation")

public class ReservationRestController {

    IReservationService reservationService;

    // http://localhost:8089/tpfoyer/reservation/retrieve-all-reservations
    @GetMapping("/retrieve-all-reservations")
    public List<Reservation> getreservations() {
        List<Reservation> listreservations = reservationService.retrieveAllReservations();
        return listreservations;
    }
    // http://localhost:8089/tpfoyer/reservation/retrieve-reservation/8
    @GetMapping("/retrieve-reservation/{reservation-id}")
    public Reservation retrievereservation(@PathVariable("reservation-id") String idReservation ) {
        Reservation reservation = reservationService.retrieveReservations(idReservation);
        return reservation;
    }

    // http://localhost:8089/tpfoyer/reservation/add-reservation
    @PostMapping("/add-reservation")
    public Reservation addreservation(@RequestBody Reservation c) {
        Reservation reservation = reservationService.addReservations(c);
        return reservation;
    }
    // http://localhost:8089/tpfoyer/reservation/remove-reservation/{reservation-id}
    @DeleteMapping("/remove-reservation/{reservation-id}")
    public void removereservation(@PathVariable("reservation-id") String idReservation) {
        reservationService.removeReservations(idReservation);
    }

    // http://localhost:8089/tpfoyer/reservation/modify-reservation
    @PutMapping("/modify-reservation")
    public Reservation modifyreservation(@RequestBody Reservation c) {
        Reservation reservation = reservationService.modifyReservations(c);
        return reservation;
    }
    @PutMapping("/affecter-reservation-a-etudiant/{reservation-id}/{etudiant-id}")
        public void affecterreservationTofoyer(@PathVariable("reservation-id") String idreservation,
                                          @PathVariable("etudiant-id") Long idFoyer) {
        reservationService.assignfoyerTouniversite(idreservation, idFoyer);
    }
/*
    @PutMapping("/desaffecter-etudaint-a-reservation-details/{reservation-id}")
    public void desaffecterreservationTofoyer(@PathVariable("reservation-id") String idreservation) {
        universityService.unassignfoyerToreservation(idreservation);
    }

    @PostMapping("/addreservationetluiaffecterunetudiant/{foyer-id}")
    public void addreservationetluiaffecterreservationTofoyer(@RequestBody reservation c, @PathVariable("foyer-id") Long idFoyer)


    {
        universityService.addreservationAndassignfoyerToreservation(c,idFoyer);
    }



*/
@GetMapping("/retrieve-reserv-selon-date-et-status/{date}/{validite}")
public List<Reservation> trouverresrevationselondateetstatus(@PathVariable("date") @DateTimeFormat(iso= DateTimeFormat.ISO.DATE) Date anneuniv, @PathVariable("validite") boolean validite) {
    return reservationService.trouverresrevationselondateetstatus(anneuniv,validite);

}


}
