package com.irisi.local.rest;

import com.irisi.local.bean.Redevable;
import com.irisi.local.rest.api.RedevableApi;
import com.irisi.local.rest.dto.RedevableDto;
import com.irisi.local.service.RedevableService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RedevableRest implements RedevableApi {


    private final RedevableService redevableService;
    private final ModelMapper modelMapper;


    public RedevableRest(RedevableService redevableService, ModelMapper modelMapper) {
        this.redevableService = redevableService;
        this.modelMapper = modelMapper;
    }

    @Override
    public RedevableDto save(RedevableDto redevableDto) {
        Redevable redevable =modelMapper.map(redevableDto,Redevable.class);
        redevable =redevableService.save(redevable);
        return modelMapper.map(redevable,RedevableDto.class);
    }

    @Override
    public List<RedevableDto> findAll() {
        return redevableService.findAll().stream().map(ele ->modelMapper.map(ele,RedevableDto.class)).collect(Collectors.toList());
    }
}
