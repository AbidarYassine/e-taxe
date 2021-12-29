package com.irisi.reportingservice.pojo;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TauxTaxeSejourPojo {
    String dateMinApplication;
    String dateMaxApplication;
    Double taux;


}
