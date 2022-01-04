package com.fstg.taxesejour.infrastructure.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "taxeSejourTrim")
@Builder
public class TaxeSejourTrim extends AbstractEntity {
    int numTrim;
    int annee;
    String ref;
    Long nombreNuit;
    BigDecimal montant;
    BigDecimal montantRetard;
    @Temporal(TemporalType.DATE)
    Date datePresentation;
    @ManyToOne()
    TauxTaxeSejour tauxTaxeSejour;
    @OneToOne(optional = true)
    TauxRetardTaxeSejourTrim tauxRetardTaxeSejourTrim;
    BigDecimal premierMoisRetard;
    BigDecimal autreMoisRetard;
    BigDecimal nombreMoisRetard;

}
