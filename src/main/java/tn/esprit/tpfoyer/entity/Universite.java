package tn.esprit.tpfoyer.entity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)//mettre ttes les attributs private
public class Universite {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    long idUniversite;
    String nomUniversite;
    String adresse ;

    @OneToOne
    private Foyer foyer;
}