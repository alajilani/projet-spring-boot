package tn.esprit.tpfoyer.service;

import tn.esprit.tpfoyer.entity.Etudiant;

import java.util.List;

public interface IEtudiantService {

    public List<Etudiant> retrieveAllEtudiants();
    public Etudiant retrieveEtudiants(Long idEtudiant);
    public Etudiant addEtudiants(Etudiant c);
    public void removeEtudiants(Long idEtudiant);
    public Etudiant modifyEtudiants(Etudiant etudiant);
// Here we will add later methods calling keywords and methods calling JPQL
}
