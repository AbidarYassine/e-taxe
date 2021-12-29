package com.irisi.local.bean;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Local implements Serializable {

    /**
     *
     */
    static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(unique = true)
    String ref;
    String nom;
    String numeroCaissier;
    String nomCommercial;
    int dernierTrimPayer;
    int dernierAnneePayer;
    @ManyToOne
    Redevable redevable;

    @ManyToOne
    Rue rue;
    @ManyToOne
    Activite activite;

    @ManyToOne
    Declaration declaration;


}
