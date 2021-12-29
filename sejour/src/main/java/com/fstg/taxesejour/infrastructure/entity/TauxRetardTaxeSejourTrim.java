package com.fstg.taxesejour.infrastructure.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity(name = "tauxRetardTaxeSejourTrim")
@Table(name = "tauxRetardTaxeSejourTrim")
@Data
@Builder
public class TauxRetardTaxeSejourTrim extends AbstractEntity {
    Double premierMoisRetard; // 15 DH par nuit
    Double autreMoisRetard; // 7DH par nuit
    @Temporal(TemporalType.DATE)
    Date dateApplicationMin;
    @Temporal(TemporalType.DATE)
    Date dateApplicationMax;

}
