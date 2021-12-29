package com.irisi.local.bean;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Secteur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String nom;

    @OneToMany(mappedBy = "secteur")
    List<AnnexAdministrative> annexAdministratives ;

    @OneToMany(mappedBy = "secteur")
    List<Zone> zones;
    @ManyToOne
    Commune commune;


}
