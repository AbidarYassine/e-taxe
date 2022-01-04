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
public class Activite extends AbstractEntity{

    String nom;

    @OneToMany(mappedBy = "activite")
    List<Local> locals;


}
