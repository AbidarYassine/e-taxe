package com.irisi.local.rest;

import com.irisi.local.bean.Quartier;
import com.irisi.local.rest.api.QuartierApi;
import com.irisi.local.rest.dto.QuartierDto;
import com.irisi.local.service.QuartierService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class QuartierRest implements QuartierApi {


    private final QuartierService quartierService;
    private final ModelMapper modelMapper;


    public QuartierRest(QuartierService quartierService, ModelMapper modelMapper) {
        this.quartierService = quartierService;
        this.modelMapper = modelMapper;
    }

    @Override
    public QuartierDto save(QuartierDto quartierDto) {
        Quartier quartier =modelMapper.map(quartierDto,Quartier.class);
        quartier =quartierService.save(quartier);
        return modelMapper.map(quartier,QuartierDto.class);
    }

    @Override
    public List<QuartierDto> findAll() {
        return quartierService.findAll().stream().map(ele ->modelMapper.map(ele,QuartierDto.class)).collect(Collectors.toList());
    }
}
