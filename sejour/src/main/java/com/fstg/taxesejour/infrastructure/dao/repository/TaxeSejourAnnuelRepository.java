package com.fstg.taxesejour.infrastructure.dao.repository;

import com.fstg.taxesejour.infrastructure.entity.TaxeSejourAnnuele;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxeSejourAnnuelRepository extends JpaRepository<TaxeSejourAnnuele, Long> {
    TaxeSejourAnnuele findByRef(String ref);

    int deleteByRef(String ref);

    TaxeSejourAnnuele findByAnnee(int annee);

    boolean existsByRef(String ref);

}
