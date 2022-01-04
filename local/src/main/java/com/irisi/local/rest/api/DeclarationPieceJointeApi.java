package com.irisi.local.rest.api;

import com.irisi.local.rest.dto.DeclarationPieceJointeDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequestMapping("/api/local/declaration-piece-jointe")
public interface DeclarationPieceJointeApi {

    @PostMapping(value = "/",consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE })
     DeclarationPieceJointeDto save(@RequestPart("declarationPieceJointe") String declarationPieceJointeDto,@RequestPart("file")  MultipartFile file);


    @GetMapping("/")
     List<DeclarationPieceJointeDto> findAll();

    

}
