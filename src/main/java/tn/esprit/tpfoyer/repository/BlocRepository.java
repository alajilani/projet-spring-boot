package tn.esprit.tpfoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tpfoyer.entity.Bloc;

import java.util.List;

public interface BlocRepository extends JpaRepository<Bloc,Long> {

    //recuperer les blocs qui ont une capacite superieure à 50 avec la methode semi prete(keywords)
    List<Bloc> findAllByCapaciteBlocGreaterThan(long c);// long tjrs avec l miniscule

}
