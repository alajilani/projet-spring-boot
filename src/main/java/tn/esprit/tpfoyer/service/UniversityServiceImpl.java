package tn.esprit.tpfoyer.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.entity.Universite;
import tn.esprit.tpfoyer.repository.FoyerRepository;
import tn.esprit.tpfoyer.repository.UniversityRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class UniversityServiceImpl implements IUniversityService{
    UniversityRepository universityrepository;
    FoyerRepository foyerrepository;
    public List<Universite> retrieveAlluniversites() {
        return universityrepository.findAll();
    }
    public Universite retrieveuniversites(Long idUniversite) {
        return universityrepository.findById(idUniversite).orElse(null);
    }
    public Universite adduniversites(Universite c) {
        return universityrepository.save(c);
    }
    public void removeuniversites(Long idUniversite) {
        universityrepository.deleteById(idUniversite);
    }
    public Universite modifyuniversites(Universite universite) {
        return universityrepository.save(universite);
    }

    public void assignfoyerTouniversite(Long idUniversité, Long idFoyer){
        Universite universite = universityrepository.findById(idUniversité).get();
        Foyer foyer = foyerrepository.findById(idFoyer).get();
// on set le fils dans le parent :
        universite.setFoyer(foyer);
        universityrepository.save(universite);
    }

    public void unassignfoyerTouniversite(Long idUniversité){
        Universite universite = universityrepository.findById(idUniversité).get();

// on deaffect le fils dans le parent :
        universite.setFoyer(null);
        universityrepository.save(universite);
    }
    public Universite adduniversiteAndassignfoyerTouniversite(Universite universite, Long idFoyer){
        Foyer foyer = foyerrepository.findById(idFoyer).get();
// on set le fils dans le parent :
        universite.setFoyer(foyer);
        return universityrepository.save(universite);


    }

}
