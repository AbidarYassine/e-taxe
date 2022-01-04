package com.irisi.local.rest.api;

import com.irisi.local.rest.dto.AnnexAdministrativeDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/local/annex-administrative")
public interface AnnexAdministrativeApi {

    @PostMapping("/")
    public AnnexAdministrativeDto save(@RequestBody AnnexAdministrativeDto annexAdministrativeDto);


    @GetMapping("/")
    public List<AnnexAdministrativeDto> findAll();

    

}
