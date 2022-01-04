package com.fstg.taxesejour.application.converter;

import com.fstg.taxesejour.application.dto.TauxTaxeSejourDto;
import com.fstg.taxesejour.infrastructure.entity.TauxTaxeSejour;
import org.springframework.stereotype.Component;

@Component
public class TauxTaxeSejourConverter {

    public TauxTaxeSejour voToBean(TauxTaxeSejourDto tauxTaxeSejourDto) {
//        return TauxTaxeSejour.builder()
//                .taux(Double.parseDouble(tauxTaxeSejourDto.getTaux()))
//                .dateMinApplication(Utils.stringToDate(tauxTaxeSejourDto.getDateMinApplication()))
//                .dateMaxApplication(Utils.stringToDate(tauxTaxeSejourDto.getDateMaxApplication()))
//                .build();
        return null;
    }
}
