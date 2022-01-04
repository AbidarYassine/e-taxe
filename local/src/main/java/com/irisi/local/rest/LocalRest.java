package com.irisi.local.rest;

import com.irisi.local.bean.Local;
import com.irisi.local.rest.api.LocalApi;
import com.irisi.local.rest.dto.LocalDto;
import com.irisi.local.service.LocalService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class LocalRest implements LocalApi {


    private final LocalService localService;
    private final ModelMapper modelMapper;

    public LocalRest(LocalService localService, ModelMapper modelMapper) {
        this.localService = localService;
        this.modelMapper = modelMapper;
    }

    public LocalDto save(LocalDto localDto) {
        Local local =modelMapper.map(localDto,Local.class);
        local= localService.save(local);
        return  modelMapper.map(local, LocalDto.class);
    }
    @Override
    public List<LocalDto> findAll() {
        return localService.findAll().stream().map(ele -> modelMapper.map(ele, LocalDto.class)).collect(Collectors.toList());
    }

    @Override
    public LocalDto findByRef(String ref) {
        if (ref == null) return null;
        return modelMapper.map(localService.findByRef(ref), LocalDto.class);
    }

    @Override
    public boolean existsByRef(String ref) {
        return modelMapper.map(localService.existsByRef(ref), Boolean.class);
    }

    @Override
    public boolean update(LocalDto localDto) {
        return localService.update(localDto);
    }
}
