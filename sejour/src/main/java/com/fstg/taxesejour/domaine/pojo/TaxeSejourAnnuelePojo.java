package com.fstg.taxesejour.domaine.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaxeSejourAnnuelePojo {
    Long id;
    String ref;
    int annee;
    BigDecimal nombreNuit;
    String refLocal;
    Date datePresentation;
}
