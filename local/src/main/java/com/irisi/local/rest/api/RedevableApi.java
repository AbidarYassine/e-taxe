package com.irisi.local.rest.api;

import com.irisi.local.rest.dto.RedevableDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/local/redevable")
public interface RedevableApi {

    @PostMapping("/")
    public RedevableDto save(@RequestBody RedevableDto redevableDto);


    @GetMapping("/")
    public List<RedevableDto> findAll();

    

}
