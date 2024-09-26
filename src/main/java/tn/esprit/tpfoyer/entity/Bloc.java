package tn.esprit.tpfoyer.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString//pour afficher le bloc dans la console et non pas leur adresses
@FieldDefaults(level = AccessLevel.PRIVATE)//mettre ttes les attributs private

public class Bloc {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)//
    long idBloc;
    String nomBloc;
    long capaciteBloc;

    @ManyToOne(cascade = CascadeType.ALL)// dans le parent je cascade vers le fils
    Foyer foyer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="bloc",fetch=FetchType.EAGER)//fetch c pour que les chambres saffiche quand on affiche le bloc , si on met pas le blloc naffiche pas ces chambres car c lazy par defauts
    private Set<Chambre> chambres;


}
