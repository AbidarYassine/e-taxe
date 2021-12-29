package com.irisi.local.bean;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeclarationPieceJointe extends AbstractEntity {

    String nom;
    String url;
    String description;
    @ManyToOne
    Declaration declaration;

}
