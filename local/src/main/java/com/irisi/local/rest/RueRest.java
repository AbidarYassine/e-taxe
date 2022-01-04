package com.irisi.local.rest;

import com.irisi.local.bean.Rue;
import com.irisi.local.rest.api.RueApi;
import com.irisi.local.rest.dto.RueDto;
import com.irisi.local.service.RueService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RueRest implements RueApi {


    private final RueService rueService;
    private final ModelMapper modelMapper;


    public RueRest(RueService rueService, ModelMapper modelMapper) {
        this.rueService = rueService;
        this.modelMapper = modelMapper;
    }

    @Override
    public RueDto save(RueDto rueDto) {
        Rue rue =modelMapper.map(rueDto,Rue.class);
        rue =rueService.save(rue);
        return modelMapper.map(rue,RueDto.class);
    }

    @Override
    public List<RueDto> findAll() {
        return rueService.findAll().stream().map(ele ->modelMapper.map(ele,RueDto.class)).collect(Collectors.toList());
    }
}
