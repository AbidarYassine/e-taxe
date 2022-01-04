package com.irisi.local.service;

import com.irisi.local.bean.DeclarationPieceJointe;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface DeclarationPieceJointeService {
   DeclarationPieceJointe save(DeclarationPieceJointe declarationPieceJointe, MultipartFile file);
   List<DeclarationPieceJointe> findAll();
}
