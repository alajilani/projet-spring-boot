package tn.esprit.tpfoyer.service;

import tn.esprit.tpfoyer.entity.Bloc;


import java.util.List;

public interface IBlocService {

    public List<Bloc> retrieveAllBlocs();
    public Bloc retrieveBlocs(Long idBloc);
    public Bloc addBlocs(Bloc c);
    public void removeBlocs(Long idBloc);
    public Bloc modifyBlocs(Bloc bloc);
// Here we will add later methods calling keywords and methods calling JPQL
}
