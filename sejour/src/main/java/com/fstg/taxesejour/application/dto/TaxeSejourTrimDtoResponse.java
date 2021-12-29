package com.fstg.taxesejour.application.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaxeSejourTrimDtoResponse {

    String ref;
    int annee;
    int numTrim;
    long nombreNuit;
    String datePresentation;
    BigDecimal montant;
    BigDecimal montantRetard;


}
