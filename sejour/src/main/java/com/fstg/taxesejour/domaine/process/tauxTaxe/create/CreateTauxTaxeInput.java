package com.fstg.taxesejour.domaine.process.tauxTaxe.create;

import java.math.BigDecimal;

public record CreateTauxTaxeInput(String ref, String dateMinApplication, String dateMaxApplication, Double taux) {
}
