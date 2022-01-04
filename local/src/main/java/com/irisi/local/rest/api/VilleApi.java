package com.irisi.local.rest.api;

import com.irisi.local.rest.dto.VilleDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/local/ville")
public interface VilleApi {

    @PostMapping("/")
    public VilleDto save(@RequestBody VilleDto villeDto);


    @GetMapping("/")
    public List<VilleDto> findAll();

    

}
