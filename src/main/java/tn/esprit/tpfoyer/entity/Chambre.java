
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
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)//mettre ttes les attributs private
public class Chambre {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)//cest à dire l'id va se remplir tpout seul , on va pas nous le remplir
    Long idChambre;
    Long numeroChambre;
    @Enumerated(EnumType.STRING)
    TypeChambre typeC;

    @ManyToOne Bloc bloc;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Reservation> reservations;

}
