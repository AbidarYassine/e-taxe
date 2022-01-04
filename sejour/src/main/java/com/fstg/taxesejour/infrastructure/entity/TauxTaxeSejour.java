package com.fstg.taxesejour.infrastructure.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "tauxTaxeSejour")
@Data
@Builder
@ToString
public class TauxTaxeSejour extends AbstractEntity {
    @Temporal(TemporalType.DATE)
    Date dateMinApplication;
    @Temporal(TemporalType.DATE)
    Date dateMaxApplication;
    Double taux;

}
