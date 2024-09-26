package tn.esprit.tpfoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.entity.TypeChambre;

import java.util.List;

public interface ChambreRepository extends JpaRepository<Chambre,Long> {

    //trouver ttes les chambes de type simple (avec methode keywords) mais attention on ne specifie le type simple car on va le specifier apres dans la service
    List<Chambre>findAllByTypeC(TypeChambre t );

    //rq tres tres imp: on utilise keywords lorsque on l'acce au attribut de notre attribut et les autres attributs
    // de notre relation qui est seulement one to one (comme foyer avec université) mais one to many on ne peut pas comme chambre et reservations et ca est resolu avec jpql


    @Query("SELECT ch FROM Chambre ch " +
            "INNER JOIN ch.reservations r " +
            "INNER JOIN r.etudiants e " +
            "WHERE e.cin =:cin ")
    List<Chambre> trouverchambresemlonetudiant(long cin);





}
