package tn.esprit.tpfoyer.control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.entity.TypeChambre;
import tn.esprit.tpfoyer.service.IChambreService;

import java.util.List;


@Tag(name = "Gestion Chambre")

    @RestController
    @AllArgsConstructor
    @RequestMapping("/chambre")
    public class ChambreRestController {
        IChambreService chambreService;
      @Operation(description = "récupérer toutes les chambres de la base de données")


        // http://localhost:8089/tpfoyer/chambre/retrieve-all-chambres
        @GetMapping("/retrieve-all-chambres")
        public List<Chambre> getChambres() {
            List<Chambre> listChambres = chambreService.retrieveAllChambres();
            return listChambres;
        }
        // http://localhost:8089/tpfoyer/chambre/retrieve-chambre/8
        @GetMapping("/retrieve-chambre/{chambre-id}")
        public Chambre retrieveChambre(@PathVariable("chambre-id") Long chId) {
            Chambre chambre = chambreService.retrieveChambre(chId);
            return chambre;
        }

        // http://localhost:8089/tpfoyer/chambre/add-chambre
        @PostMapping("/add-chambre")
        public Chambre addChambre(@RequestBody Chambre c) {
            Chambre chambre = chambreService.addChambre(c);
            return chambre;
        }
        // http://localhost:8089/tpfoyer/chambre/remove-chambre/{chambre-id}
        @DeleteMapping("/remove-chambre/{chambre-id}")
        public void removeChambre(@PathVariable("chambre-id") Long chId) {
            chambreService.removeChambre(chId);
        }
        // http://localhost:8089/tpfoyer/chambre/modify-chambre
        @PutMapping("/modify-chambre")
        public Chambre modifyChambre(@RequestBody Chambre c) {
            Chambre chambre = chambreService.modifyChambre(c);
            return chambre;
        }

    @PutMapping("/getchambreselontypye/{type-chambre}")
    public List<Chambre> recupererchambreselontype(@PathVariable("type-chambre") TypeChambre t) {
        List<Chambre>  chambres = chambreService.recupererchambreselontype(t);
        return chambres;
    }




    }

