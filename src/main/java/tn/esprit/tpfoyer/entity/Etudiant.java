package tn.esprit.tpfoyer.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)//mettre ttes les attributs private
public class Etudiant {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)//
    long idEtudiant;
    String nomEt;
    String prenomEt;
    long cin;
    String ecole;
    Date dateNaissance;

    @ManyToMany(cascade = CascadeType.ALL,mappedBy="etudiants")//fetch = FetchType.EAGER ce code on le met dans dans manytomanyou one to many pour que chaque etudiant affiche la liste de son reservation , si on le met pas il va etre lazy et il va signaler un erreur
    @ToString.Exclude//ne permet pas dafficher la liste des reservations de chaque etudiants
    private Set<Reservation> reservations;

    //rq: la diff entre @ToString.Exclude et json ignore : tostringexlude ne permet pas lafffichage seulement dans la console
    //et jsonignore naffiche pas les donnes dans manipulation reele cad dans swager ou dans lintegration back avec front
}
