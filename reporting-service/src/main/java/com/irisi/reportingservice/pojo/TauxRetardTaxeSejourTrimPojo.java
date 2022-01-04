package com.irisi.reportingservice.pojo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class TauxRetardTaxeSejourTrimPojo {
    Long id;
    Double premierMoisRetard; // 10DH
    Double autreMoisRetard; // 7DH
    String dateApplicationMin;
    String dateApplicationMax;


}
