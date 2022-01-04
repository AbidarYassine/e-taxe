package com.fstg.taxesejour.infrastructure.dao.repository;

import com.fstg.taxesejour.infrastructure.entity.TauxTaxeSejour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface TauxTaxeSejourRepository extends JpaRepository<TauxTaxeSejour, Long> {
    TauxTaxeSejour findByRef(String ref);

    int deleteByRef(String ref);

    boolean existsByRef(String ref);

    //     JPQL
//    @Query("SELECT t From TauxTaxeSejour t WHERE t.dateMinApplication < :date AND  t.dateMaxApplication > :date")
//    TauxTaxeSejour getTauxByCurrnetDate(Date date);


//    @Query(value = "SELECT * From taux_taxe_sejour WHERE  date_min_application<:date AND date_max_application >:date", nativeQuery = true)
//    TauxTaxeSejour getTauxByCurrnetDate(Date date);

//    @Query(value = "from EntityClassTable t where yourDate BETWEEN :startDate AND :endDate")
//    TauxTaxeSejour getAllBetweenDates(@Param("startDate")Date startDate,@Param("endDate")Date endDate);

//    @Query(value = "SELECT * From taux_taxe_sejour  WHERE  taux_taxe_sejour.date_min_application < :date AND  taux_taxe_sejour.date_max_application >:date",nativeQuery = true)
//    TauxTaxeSejour getTauxByCurrnetDate(String date);

//    TauxTaxeSejour findByDateMinApplicationLessThanAndDateMaxApplicationGreaterThan(Date date);

    @Query(value = "SELECT * From taux_taxe_sejour WHERE  date_min_application<:date AND date_max_application >:date", nativeQuery = true)
    TauxTaxeSejour getTauxByCurrnetDate(Date date);

}
