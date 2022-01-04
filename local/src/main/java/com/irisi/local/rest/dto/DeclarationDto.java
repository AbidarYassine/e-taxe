package com.irisi.local.rest.dto;
import java.util.List;

public class DeclarationDto{
    private Long id;
    private String ref;
    private List<DeclarationPieceJointeDto>  declarationPieceJointes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public List<DeclarationPieceJointeDto> getDeclarationPieceJointes() {
        return declarationPieceJointes;
    }

    public void setDeclarationPieceJointes(List<DeclarationPieceJointeDto> declarationPieceJointes) {
        this.declarationPieceJointes = declarationPieceJointes;
    }
}
