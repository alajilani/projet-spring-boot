package tn.esprit.tpfoyer.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.repository.BlocRepository;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
@Slf4j// pour que log marche
public class BlocServiceImpl   implements IBlocService{

   BlocRepository BlocRepository;
   @Scheduled(fixedDelay = 30000)//millisecondes
   public List<Bloc> retrieveAllBlocs() {
       List<Bloc> listB = BlocRepository.findAll();
       log.info("Taille totale : " + listB.size());
       for (Bloc b : listB) {
           if (b.getCapaciteBloc() >= 50) {
               log.info("Bloc : " + b);
           }
       }
       return listB;
   }
   //recuperer les blocs qui ont une capacite superieure à 50 sans la methode (keywords)

    /*public List<Bloc> retrieveBlocsseloncapacite(long c) {

            List<Bloc> listB = BlocRepository.findAll();
            List<Bloc> listBseloncapacite = new ArrayList<>();


            for (Bloc b : listB) {
                if (b.getCapaciteBloc() >= c)

                    listBseloncapacite.add(b);

            }
            return listBseloncapacite ;

    }

     */
    public Bloc retrieveBlocs(Long idBloc) {
        return BlocRepository.findById(idBloc).orElse(null);
    }
    public Bloc addBlocs(Bloc c) {
        return BlocRepository.save(c);
    }
    public void removeBlocs(Long idBloc) {
        BlocRepository.deleteById(idBloc);
    }
    public Bloc modifyBlocs(Bloc bloc) {
        return BlocRepository.save(bloc);
    }
}
