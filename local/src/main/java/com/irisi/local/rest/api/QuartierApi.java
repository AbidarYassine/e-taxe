package com.irisi.local.rest.api;

import com.irisi.local.rest.dto.QuartierDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/local/quartier")
public interface QuartierApi {

    @PostMapping("/")
    public QuartierDto save(@RequestBody QuartierDto quartierDto);


    @GetMapping("/")
    public List<QuartierDto> findAll();

    

}
