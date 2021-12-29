package com.fstg.taxesejour.domaine.pojo;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TauxTaxeSejourPojo {
    Date dateMinApplication;
    Date dateMaxApplication;
    Double taux;
    long id;


}
