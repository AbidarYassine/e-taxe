package com.irisi.local.rest;

import com.irisi.local.bean.Activite;
import com.irisi.local.rest.api.ActiviteApi;
import com.irisi.local.rest.dto.ActiviteDto;
import com.irisi.local.service.ActiviteService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ActiviteRest implements ActiviteApi {


    private final ActiviteService activiteService;
    private final ModelMapper modelMapper;


    public ActiviteRest(ActiviteService activiteService, ModelMapper modelMapper) {
        this.activiteService = activiteService;
        this.modelMapper = modelMapper;
    }

    @Override
    public ActiviteDto save(ActiviteDto activiteDto) {
        Activite activite =modelMapper.map(activiteDto,Activite.class);
        activite =activiteService.save(activite);
        return modelMapper.map(activite,ActiviteDto.class);
    }

    @Override
    public List<ActiviteDto> findAll() {
        return activiteService.findAll().stream().map(ele ->modelMapper.map(ele,ActiviteDto.class)).collect(Collectors.toList());
    }
}
