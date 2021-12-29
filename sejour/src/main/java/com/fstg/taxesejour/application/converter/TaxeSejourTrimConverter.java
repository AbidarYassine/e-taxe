package com.fstg.taxesejour.application.converter;

import com.fstg.taxesejour.application.dto.TaxeSejourTrimDto;
import com.fstg.taxesejour.infrastructure.entity.TaxeSejourTrim;
import org.springframework.stereotype.Component;

@Component
public class TaxeSejourTrimConverter {
    public TaxeSejourTrim voToBean(TaxeSejourTrimDto taxeSejourTrimDtoVO) {
//        return TaxeSejourTrim.builder()
//                .annee(Integer.parseInt(taxeSejourTrimDtoVO.getAnnee()))
//                .ref(taxeSejourTrimDtoVO.getRef())
//                .numTrim(Integer.parseInt(taxeSejourTrimDtoVO.getNumTrim()))
//                .build();
        return null;
    }

}
