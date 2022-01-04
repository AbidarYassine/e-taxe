package com.irisi.reportingservice.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Local implements Serializable {
    private static final long serialVersionUID = 5628817130716181708L;
    private String ref;
    private Long id;
    private String nom;
    int dernierAnneePayer;
    int dernierTrimPayer;

    public Local(String ref, int dernierAnneePayer, int dernierTrimPayer) {
        this.ref = ref;
        this.dernierAnneePayer = dernierAnneePayer;
        this.dernierTrimPayer = dernierTrimPayer;
    }

    public Local() {
    }
}
