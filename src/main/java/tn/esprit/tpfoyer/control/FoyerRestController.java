package tn.esprit.tpfoyer.control;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.service.IFoyerService;

import java.util.List;
@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
public class FoyerRestController {

    IFoyerService foyerService;

    // http://localhost:8089/tpfoyer/foyer/retrieve-all-foyers
    @GetMapping("/retrieve-all-foyers")
    public List<Foyer> getfoyers() {
        List<Foyer> listfoyers = foyerService.retrieveAllFoyers();
        return listfoyers;
    }
    // http://localhost:8089/tpfoyer/foyer/retrieve-foyer/8
    @GetMapping("/retrieve-foyer/{foyer-id}")
    public Foyer retrievefoyer(@PathVariable("foyer-id") Long idFoyer ) {
        Foyer foyer = foyerService.retrieveFoyers(idFoyer);
        return foyer;
    }

    // http://localhost:8089/tpfoyer/foyer/add-foyer
    @PostMapping("/add-foyer")
    public Foyer addfoyer(@RequestBody Foyer c) {
        Foyer foyer = foyerService.addFoyers(c);
        return foyer;
    }
    // http://localhost:8089/tpfoyer/foyer/remove-foyer/{foyer-id}
    @DeleteMapping("/remove-foyer/{foyer-id}")
    public void removefoyer(@PathVariable("foyer-id") Long idFoyer) {
        foyerService.removeFoyers(idFoyer);
    }
    // http://localhost:8089/tpfoyer/foyer/modify-foyer
    @PutMapping("/modify-foyer")
    public Foyer modifyfoyer(@RequestBody Foyer c) {
        Foyer foyer = foyerService.modifyFoyers(c);
        return foyer;
    }

}
