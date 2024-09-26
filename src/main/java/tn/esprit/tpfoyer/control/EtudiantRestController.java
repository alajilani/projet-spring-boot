package tn.esprit.tpfoyer.control;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Etudiant;
import tn.esprit.tpfoyer.service.IEtudiantService;

import java.util.List;
@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantRestController {

    IEtudiantService etudiantService;

    // http://localhost:8089/tpfoyer/etudiant/retrieve-all-etudiants
    @GetMapping("/retrieve-all-etudiants")
    public List<Etudiant> getetudiants() {
        List<Etudiant> listetudiants = etudiantService.retrieveAllEtudiants();
        return listetudiants;
    }
    // http://localhost:8089/tpfoyer/etudiant/retrieve-etudiant/8
    @GetMapping("/retrieve-etudiant/{etudiant-id}")
    public Etudiant retrieveetudiant(@PathVariable("etudiant-id") Long idEtudiant ) {
        Etudiant etudiant = etudiantService.retrieveEtudiants(idEtudiant);
        return etudiant;
    }

    // http://localhost:8089/tpfoyer/etudiant/add-etudiant
    @PostMapping("/add-etudiant")
    public Etudiant addetudiant(@RequestBody Etudiant c) {
        Etudiant etudiant = etudiantService.addEtudiants(c);
        return etudiant;
    }
    // http://localhost:8089/tpfoyer/etudiant/remove-etudiant/{etudiant-id}
    @DeleteMapping("/remove-etudiant/{etudiant-id}")
    public void removeetudiant(@PathVariable("etudiant-id") Long idEtudiant) {
        etudiantService.removeEtudiants(idEtudiant);
    }
    // http://localhost:8089/tpfoyer/etudiant/modify-etudiant
    @PutMapping("/modify-etudiant")
    public Etudiant modifyetudiant(@RequestBody Etudiant c) {
        Etudiant etudiant = etudiantService.modifyEtudiants(c);
        return etudiant;
    }

}
