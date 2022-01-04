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
public class Commune {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String nom;

    @OneToMany(mappedBy = "commune")
    List<Secteur> secteurs;
    @ManyToOne
    Ville ville;

}
