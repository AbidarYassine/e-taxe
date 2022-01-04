package com.irisi.local.rest.api;

import com.irisi.local.rest.dto.CommuneDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/local/commune")
public interface CommuneApi {

    @PostMapping("/")
    public CommuneDto save(@RequestBody CommuneDto communeDto);


    @GetMapping("/")
    public List<CommuneDto> findAll();

    

}
