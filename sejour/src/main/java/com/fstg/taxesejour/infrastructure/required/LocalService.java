package com.fstg.taxesejour.infrastructure.required;

import com.fstg.taxesejour.domaine.pojo.Local;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "LOCAL-SERVICE")
public interface LocalService {
    @GetMapping("/api/local/exist/ref/{ref}")
    boolean existByRef(@PathVariable String ref);

    @GetMapping("/api/local/ref/{ref}")
    Local findByRef(@PathVariable String ref);

    @PutMapping("/api/local/")
    boolean update(@RequestBody Local local);


}
