package com.irisi.local.bean;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Redevable extends AbstractEntity {

    String nom;
    String prenom;
    String email;
    String password;
    String adresse;
    @OneToMany(mappedBy = "redevable")
    List<Local> locals;


}
