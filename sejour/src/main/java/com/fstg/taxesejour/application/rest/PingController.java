package com.fstg.taxesejour.application.rest;

import com.fstg.taxesejour.utils.Constant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = Constant.APP_ROOT)
public class PingController {

    @GetMapping("/")
    public String ping() {
        return "ok";
    }
}
