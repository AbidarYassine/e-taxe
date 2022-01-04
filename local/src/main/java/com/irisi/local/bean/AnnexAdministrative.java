package com.irisi.local.bean;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnnexAdministrative implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     Long id;
     String nom;
     String numero;

     @OneToMany(mappedBy = "annexAdministrative")
     List<Quartier> quartiers;

     @ManyToOne
     Secteur secteur;


}
