package tn.esprit.tpfoyer.service;

import tn.esprit.tpfoyer.entity.Foyer;

import java.util.List;

public interface IFoyerService {

    public List<Foyer> retrieveAllFoyers();
    public Foyer retrieveFoyers(Long idFoyer);
    public Foyer addFoyers(Foyer c);
    public void removeFoyers(Long idFoyer);
    public Foyer modifyFoyers(Foyer foyer);
// Here we will add later methods calling keywords and methods calling JPQL
}

