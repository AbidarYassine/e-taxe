package com.fstg.taxesejour.infrastructure.dao.repository;

import com.fstg.taxesejour.infrastructure.entity.TaxeSejourTrim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxeSejourTrimRepository extends JpaRepository<TaxeSejourTrim, Long> {
    //    converter from POJO TO ENTITY and inverse
    TaxeSejourTrim findByRef(String ref);

    int deleteByRef(String ref);

    boolean existsByRef(String ref);


    boolean existsByAnneeAndNumTrim(int annee, int numTrim);

    TaxeSejourTrim findByAnnee(int annee);

//    TaxeSejourTrim findByDateValidation(Date dateValidation);


}
