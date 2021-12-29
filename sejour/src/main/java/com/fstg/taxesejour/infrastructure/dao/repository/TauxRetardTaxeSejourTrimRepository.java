package com.fstg.taxesejour.infrastructure.dao.repository;

import com.fstg.taxesejour.infrastructure.entity.TauxRetardTaxeSejourTrim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface TauxRetardTaxeSejourTrimRepository extends JpaRepository<TauxRetardTaxeSejourTrim, Long> {
    TauxRetardTaxeSejourTrim findByRef(String ref);

    int deleteByRef(String ref);

    boolean existsByRef(String ref);
//
//    @Query("SELECT t From TauxRetardTaxeSejourTrim  t WHERE  t.dateApplicationMin<   ?1 AND t.dateApplicationMax > ?1")
//    TauxRetardTaxeSejourTrim getTauxByCurrnetDate(String date);


    @Query(value = "SELECT * From taux_retard_taxe_sejour_trim WHERE  date_application_min<:date AND date_application_max >:date", nativeQuery = true)
    TauxRetardTaxeSejourTrim getTauxByCurrnetDate(Date date);

}
