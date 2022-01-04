package com.irisi.local.bean;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Declaration extends  AbstractEntity{

    @OneToMany(mappedBy = "declaration")
    List<DeclarationPieceJointe>  declarationPieceJointes;
}
