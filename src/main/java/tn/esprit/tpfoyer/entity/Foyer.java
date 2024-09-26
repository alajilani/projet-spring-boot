package tn.esprit.tpfoyer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.builder.ToStringExclude;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)//mettre ttes les attributs private
public class Foyer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)//
    long idFoyer;
    String nomFoyer;
    long capaciteFoyer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="foyer")
    @JsonIgnore
    @ToString.Exclude
    private Set<Bloc> blocs;

    @OneToOne (cascade = CascadeType.ALL,mappedBy= "foyer")

    private Universite universite;

}
