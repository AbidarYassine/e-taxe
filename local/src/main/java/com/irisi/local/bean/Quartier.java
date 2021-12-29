package com.irisi.local.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Quartier  implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 Long id;
     String nom;
     String numero;

    @OneToMany(mappedBy = "quartier")
     List<Rue> rues;

    @ManyToOne
    AnnexAdministrative annexAdministrative;


}
