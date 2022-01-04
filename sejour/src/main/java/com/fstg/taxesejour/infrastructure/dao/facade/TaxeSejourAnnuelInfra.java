package com.fstg.taxesejour.infrastructure.dao.facade;

import com.fstg.taxesejour.domaine.pojo.TaxeSejourAnnuelePojo;
import com.fstg.taxesejour.infrastructure.entity.TaxeSejourAnnuele;

public interface TaxeSejourAnnuelInfra extends AbstractInfra<TaxeSejourAnnuele> {


    TaxeSejourAnnuele findByRef(String ref);

    int deleteByRef(String ref);

    TaxeSejourAnnuele findByAnnee(int annee);

    boolean existsByRef(String ref);

    TaxeSejourAnnuelePojo save(TaxeSejourAnnuelePojo taxeSejourAnnuelePojo);
}
