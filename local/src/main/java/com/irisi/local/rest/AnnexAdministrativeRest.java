package com.irisi.local.rest;

import com.irisi.local.bean.AnnexAdministrative;
import com.irisi.local.rest.api.AnnexAdministrativeApi;
import com.irisi.local.rest.dto.AnnexAdministrativeDto;
import com.irisi.local.service.AnnexAdministrativeService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AnnexAdministrativeRest implements AnnexAdministrativeApi {


    private final AnnexAdministrativeService annexAdministrativeService;
    private final ModelMapper modelMapper;


    public AnnexAdministrativeRest(AnnexAdministrativeService annexAdministrativeService, ModelMapper modelMapper) {
        this.annexAdministrativeService = annexAdministrativeService;
        this.modelMapper = modelMapper;
    }

    @Override
    public AnnexAdministrativeDto save(AnnexAdministrativeDto annexAdministrativeDto) {
        AnnexAdministrative annexAdministrative =modelMapper.map(annexAdministrativeDto,AnnexAdministrative.class);
        annexAdministrative =annexAdministrativeService.save(annexAdministrative);
        return modelMapper.map(annexAdministrative,AnnexAdministrativeDto.class);
    }

    @Override
    public List<AnnexAdministrativeDto> findAll() {
        return annexAdministrativeService.findAll().stream().map(ele ->modelMapper.map(ele,AnnexAdministrativeDto.class)).collect(Collectors.toList());
    }
}
