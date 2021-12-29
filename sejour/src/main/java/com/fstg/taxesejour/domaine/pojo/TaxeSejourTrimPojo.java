package com.fstg.taxesejour.domaine.pojo;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@ToString
public class TaxeSejourTrimPojo {
    String ref;
    int numTrim;
    int annee;
    Long nombreNuit;
    String refLocal;
    BigDecimal montant;
    BigDecimal montantRetard;
    Date datePresentation;
    TauxTaxeSejourPojo tauxTaxeSejour;
    TauxRetardTaxeSejourTrimPojo tauxRetardTaxeSejourTrim;
    boolean simulation;
    BigDecimal premierMoisRetard;
    BigDecimal autreMoisRetard;
    int nombreMoisRetard;


}
