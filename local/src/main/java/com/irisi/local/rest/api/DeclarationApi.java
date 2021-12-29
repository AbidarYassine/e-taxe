package com.irisi.local.rest.api;

import com.irisi.local.rest.dto.DeclarationDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/local/declaration")
public interface DeclarationApi {

    @PostMapping("/")
    public DeclarationDto save(@RequestBody DeclarationDto declarationDto);


    @GetMapping("/")
    public List<DeclarationDto> findAll();

    

}
