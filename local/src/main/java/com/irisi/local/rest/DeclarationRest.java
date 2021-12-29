package com.irisi.local.rest;

import com.irisi.local.bean.Declaration;
import com.irisi.local.rest.api.DeclarationApi;
import com.irisi.local.rest.dto.DeclarationDto;
import com.irisi.local.service.DeclarationService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DeclarationRest implements DeclarationApi {


    private final DeclarationService declarationService;
    private final ModelMapper modelMapper;


    public DeclarationRest(DeclarationService declarationService, ModelMapper modelMapper) {
        this.declarationService = declarationService;
        this.modelMapper = modelMapper;
    }

    @Override
    public DeclarationDto save(DeclarationDto declarationDto) {
        Declaration declaration =modelMapper.map(declarationDto,Declaration.class);
        declaration =declarationService.save(declaration);
        return modelMapper.map(declaration,DeclarationDto.class);
    }

    @Override
    public List<DeclarationDto> findAll() {
        return declarationService.findAll().stream().map(ele ->modelMapper.map(ele,DeclarationDto.class)).collect(Collectors.toList());
    }
}
