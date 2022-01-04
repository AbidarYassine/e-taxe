package com.fstg.taxesejour.infrastructure.dao.facade;

import com.fstg.taxesejour.domaine.pojo.TaxeSejourTrimPojo;
import com.fstg.taxesejour.infrastructure.entity.TaxeSejourTrim;

public interface TaxeSejourTrimInfra extends AbstractInfra<TaxeSejourTrimPojo> {


    TaxeSejourTrimPojo findByRef(String ref);

    int deleteByRef(String ref);

    boolean existeByRef(String ref);

    TaxeSejourTrimPojo findByAnnee(int annee);

    boolean existsByAnneeAndNumTrim(int annee, int numTrim);

}
