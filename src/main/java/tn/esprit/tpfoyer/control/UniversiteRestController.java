package tn.esprit.tpfoyer.control;

import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Universite;
import tn.esprit.tpfoyer.service.IUniversityService;

import java.util.List;

public class UniversiteRestController {
    IUniversityService universityService;

    // http://localhost:8089/tpuniversite/universite/retrieve-all-universites
    @GetMapping("/retrieve-all-universites")
    public List<Universite> getuniversites() {
        List<Universite> listuniversites = universityService.retrieveAlluniversites();
        return listuniversites;
    }
    // http://localhost:8089/tpuniversite/universite/retrieve-universite/8
    @GetMapping("/retrieve-universite/{unividersite-id}")
    public Universite retrieveuniversite(@PathVariable("unividersite-id") Long idUniversite ) {
        Universite universite = universityService.retrieveuniversites(idUniversite);
        return universite;
    }

    // http://localhost:8089/tpuniversite/universite/add-universite
    @PostMapping("/add-universite")
    public Universite adduniversite(@RequestBody Universite c) {
        Universite universite = universityService.adduniversites(c);
        return universite;
    }
    // http://localhost:8089/tpuniversite/universite/remove-universite/{universite-id}
    @DeleteMapping("/remove-universite/{universite-id}")
    public void removeuniversite(@PathVariable("universite-id") Long iduniversite) {
        universityService.removeuniversites(iduniversite);
    }
    // http://localhost:8089/tpuniversite/universite/modify-universite
    @PutMapping("/modify-universite")
    public Universite modifyuniversite(@RequestBody Universite c) {
        Universite universite = universityService.modifyuniversites(c);
        return universite;
    }

    @PutMapping("/affecter-universite-a-universite-details/{universite-id}/{foyer-id}")
    public void affecteruniversiteTofoyer(@PathVariable("universite-id") Long iduniversite,
                                            @PathVariable("foyer-id") Long idFoyer) {
        universityService.assignfoyerTouniversite(iduniversite, idFoyer);
    }

    @PutMapping("/desaffecter-universite-a-universite-details/{universite-id}")
    public void desaffecteruniversiteTofoyer(@PathVariable("universite-id") Long iduniversite) {
        universityService.unassignfoyerTouniversite(iduniversite);
    }

    @PostMapping("/adduniversiteetluiaffecterununiversitedetail/{foyer-id}")
    public void adduniversiteetluiaffecteruniversiteTofoyer(@RequestBody Universite c,@PathVariable("foyer-id") Long idFoyer)


    {
        universityService.adduniversiteAndassignfoyerTouniversite(c,idFoyer);
    }


}
