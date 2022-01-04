package com.irisi.local.rest.api;

import com.irisi.local.rest.dto.RueDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/local/rue")
public interface RueApi {

    @PostMapping("/")
    public RueDto save(@RequestBody RueDto rueDto);


    @GetMapping("/")
    public List<RueDto> findAll();

    

}
