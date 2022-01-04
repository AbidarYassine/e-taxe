package com.irisi.local.rest.api;

import com.irisi.local.rest.dto.ZoneDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/local/zone")
public interface ZoneApi {

    @PostMapping("/")
    public ZoneDto save(@RequestBody ZoneDto zoneDto);


    @GetMapping("/")
    public List<ZoneDto> findAll();

    

}
