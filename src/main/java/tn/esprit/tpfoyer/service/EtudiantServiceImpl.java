package tn.esprit.tpfoyer.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Etudiant;
import tn.esprit.tpfoyer.repository.EtudiantReposirory;

import java.util.List;
@Service
@AllArgsConstructor
@Slf4j// pour que log marche
public class EtudiantServiceImpl implements IEtudiantService {
    EtudiantReposirory etudiantRepository;

    //@Scheduled(fixedDelay = 30000)//millisecondes  cad on affiche nos donnes sur la console ttes les 30 secondes
    //@Scheduled(cron = "15 * * * * *")// qaund dans lheure on a les secondes egales 15
    //@Scheduled(cron = "0/15 * * * * *")//je commence le seconde egale zero et elle sexecute ttes les 15 secondes
    //@Scheduled(cron = "0 0/30 11 * * *")//elle commence quand le sec egale 0 et heure egale 11 et minutes egales 0 (cad elle commence 11.0.0)et elle sexecute apres chaque 30 min DONC ELLE SEXECUTE UNE SEULE FOIS DANS LE JOUR CAR ELLE SEXECUTE QUE SI LHEURE EST 11.0.0H
    //@Scheduled(cron = "0 0 8 ? 4 ?")//tous les jours de mois davril à 8.0.0
    public List<Etudiant> retrieveAllEtudiants() {
        List<Etudiant> listE= etudiantRepository.findAll();
        log.info("taille totale:"+listE.size());
        for (Etudiant E: listE){
            log.info("etudiant"+E);
        }
        return  listE;
    }
    public Etudiant retrieveEtudiants(Long idEtudiant) {
        return etudiantRepository.findById(idEtudiant).orElse(null);
    }
    public Etudiant addEtudiants(Etudiant c) {
        return etudiantRepository.save(c);
    }
    public void removeEtudiants(Long idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);
    }
    public Etudiant modifyEtudiants(Etudiant idEtudiant) {
        return etudiantRepository.save(idEtudiant);
    }
}
