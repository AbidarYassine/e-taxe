package com.irisi.local.rest.api;

import com.irisi.local.rest.dto.LocalDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/local")
public interface LocalApi {

    @PostMapping("/")
    public LocalDto save(@RequestBody LocalDto localDto);

    @GetMapping("/")
    public List<LocalDto> findAll();

    @GetMapping("/ref/{ref}")
    public LocalDto findByRef(@PathVariable String ref);

    @GetMapping("/exist/ref/{ref}")
    public boolean existsByRef(@PathVariable String ref);

    @PutMapping("/")
    boolean update(@RequestBody LocalDto localDto);


}
