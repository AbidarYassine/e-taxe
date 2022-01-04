package com.fstg.taxesejour.infrastructure.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity(name = "taxeSejourAnnuele")
public class TaxeSejourAnnuele extends AbstractEntity {
    int annee;
    BigDecimal nombreNuit;
    BigDecimal montantRetard;
    String refLocal;
    @Temporal(TemporalType.DATE)
    Date datePresentation;
    @Temporal(TemporalType.DATE)
    Date dateValidation;
}
