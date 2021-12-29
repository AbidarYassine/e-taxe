package com.irisi.local.rest;

import com.irisi.local.bean.Commune;
import com.irisi.local.rest.api.CommuneApi;
import com.irisi.local.rest.dto.CommuneDto;
import com.irisi.local.service.CommuneService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CommuneRest implements CommuneApi {


    private final CommuneService communeService;
    private final ModelMapper modelMapper;


    public CommuneRest(CommuneService communeService, ModelMapper modelMapper) {
        this.communeService = communeService;
        this.modelMapper = modelMapper;
    }

    @Override
    public CommuneDto save(CommuneDto communeDto) {
        Commune commune =modelMapper.map(communeDto,Commune.class);
        commune =communeService.save(commune);
        return modelMapper.map(commune,CommuneDto.class);
    }

    @Override
    public List<CommuneDto> findAll() {
        return communeService.findAll().stream().map(ele ->modelMapper.map(ele,CommuneDto.class)).collect(Collectors.toList());
    }
}
