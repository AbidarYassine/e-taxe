package com.fstg.taxesejour.application.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaxeSejourTrimDto {

    @NotBlank(message = "{validation.ref_vide}")
    String ref;

    @NotBlank(message = "{validation.refLocal_vide}")
    String refLocal;

    @NotNull(message = "{validation.numTrim_vide}")
    @Max(message = "{validation.numTrim_max_value}", value = 4)
    int numTrim;

    @NotNull(message = "{validation.annee_vide}")
    int annee;

    @NotNull(message = "{validation.nombreNuit_vide}")
    BigDecimal nombreNuit;

    @NotBlank(message = "{validation.refTaxeSejourAnnuel_vide}")
    String refTaxeSejourAnnuel;

    boolean simulation;

}
