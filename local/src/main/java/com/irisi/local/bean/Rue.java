package com.irisi.local.bean;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@EqualsAndHashCode(callSuper = true)
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rue  extends AbstractEntity {

	private String nom;
	private String numero;
	@ManyToOne
	private Quartier quartier;
	
	@OneToMany(mappedBy = "rue")
    private List<Local> locals;


}
