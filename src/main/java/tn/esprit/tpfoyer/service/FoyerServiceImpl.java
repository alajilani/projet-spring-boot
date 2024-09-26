package tn.esprit.tpfoyer.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.esprit.tpfoyer.entity.Etudiant;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.repository.FoyerRepository;

import java.util.List;
@Service
@AllArgsConstructor
@Slf4j// pour que log marche
public class FoyerServiceImpl implements IFoyerService{

     FoyerRepository foyerRepository;
    @Scheduled(cron = "0/20 * * * * *")//3fois par minute
    public List<Foyer> retrieveAllFoyers () {

        List<Foyer> listF= foyerRepository.findAll();
        log.info("taille totale:"+listF.size());
        for (Foyer F: listF){
            log.info("foyer"+F);
    }
        return  listF;
    }
    public Foyer retrieveFoyers(Long idFoyer) {
        return foyerRepository.findById(idFoyer).orElse(null);
    }
    public Foyer addFoyers(Foyer c) {
        return foyerRepository.save(c);
    }
    public void removeFoyers(Long idFoyer) {
        foyerRepository.deleteById(idFoyer);
    }
    public Foyer modifyFoyers(Foyer foyer) {
        return foyerRepository.save(foyer);
    }
}
