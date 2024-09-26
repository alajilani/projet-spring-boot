package tn.esprit.tpfoyer.service;

import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.entity.Universite;

import java.util.List;

public interface IUniversityService {

    public List<Universite> retrieveAlluniversites();
    public Universite retrieveuniversites(Long idUniversite);
    public Universite adduniversites(Universite c);
    public void removeuniversites(Long idUniversite);
    public Universite modifyuniversites(Universite universite);
// Here we will add later methods calling keywords and methods calling JPQL
public void assignfoyerTouniversite(Long idUniversité, Long idFoyer);
    public void unassignfoyerTouniversite(Long idUniversité);
    public Universite adduniversiteAndassignfoyerTouniversite(Universite universite, Long idFoyer);


}
