package tn.esprit.tpfoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tpfoyer.entity.Etudiant;

public interface EtudiantReposirory extends JpaRepository<Etudiant,Long> {
}
