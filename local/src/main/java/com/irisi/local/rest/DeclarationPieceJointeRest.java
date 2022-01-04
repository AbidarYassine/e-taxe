package com.irisi.local.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.irisi.local.bean.DeclarationPieceJointe;
import com.irisi.local.rest.api.DeclarationPieceJointeApi;
import com.irisi.local.rest.dto.DeclarationPieceJointeDto;
import com.irisi.local.service.DeclarationPieceJointeService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DeclarationPieceJointeRest implements DeclarationPieceJointeApi {


    private final DeclarationPieceJointeService declarationPieceJointeService;
    private final ModelMapper modelMapper;


    public DeclarationPieceJointeRest(DeclarationPieceJointeService declarationPieceJointeService, ModelMapper modelMapper) {
        this.declarationPieceJointeService = declarationPieceJointeService;
        this.modelMapper = modelMapper;
    }

    @Override
    public DeclarationPieceJointeDto save(String declarationPieceJointeDto ,MultipartFile file) {

        ObjectMapper objectMapper =new ObjectMapper();
        try {
            DeclarationPieceJointeDto declarationPieceJointeDto1 =objectMapper.readValue(declarationPieceJointeDto,DeclarationPieceJointeDto.class);
            DeclarationPieceJointe declarationPieceJointe =modelMapper.map(declarationPieceJointeDto1,DeclarationPieceJointe.class);
            declarationPieceJointe =declarationPieceJointeService.save(declarationPieceJointe,file);
            return modelMapper.map(declarationPieceJointe,DeclarationPieceJointeDto.class);

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<DeclarationPieceJointeDto> findAll() {
        return declarationPieceJointeService.findAll().stream().map(ele ->modelMapper.map(ele,DeclarationPieceJointeDto.class)).collect(Collectors.toList());
    }
}
