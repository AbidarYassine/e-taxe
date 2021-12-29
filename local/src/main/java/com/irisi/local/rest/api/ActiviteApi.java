package com.irisi.local.rest.api;

import com.irisi.local.rest.dto.ActiviteDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/local/activite")
public interface ActiviteApi {

    @PostMapping("/")

    public ActiviteDto save(@RequestBody ActiviteDto activiteDto);


    @GetMapping("/")
    public List<ActiviteDto> findAll();

    

}
