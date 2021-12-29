package com.fstg.taxesejour.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TauxTaxeSejourDto {
    String dateMinApplication;
    String dateMaxApplication;
    String ref;
    String taux;
}
