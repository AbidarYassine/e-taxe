package com.irisi.local.rest;

import com.irisi.local.bean.Ville;
import com.irisi.local.rest.api.VilleApi;
import com.irisi.local.rest.dto.VilleDto;
import com.irisi.local.service.VilleService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class VilleRest implements VilleApi {


    private final VilleService villeService;
    private final ModelMapper modelMapper;


    public VilleRest(VilleService villeService, ModelMapper modelMapper) {
        this.villeService = villeService;
        this.modelMapper = modelMapper;
    }

    @Override
    public VilleDto save(VilleDto villeDto) {
        Ville ville =modelMapper.map(villeDto,Ville.class);
        ville =villeService.save(ville);
        return modelMapper.map(ville,VilleDto.class);
    }

    @Override
    public List<VilleDto> findAll() {
        return villeService.findAll().stream().map(ele ->modelMapper.map(ele,VilleDto.class)).collect(Collectors.toList());
    }
}
