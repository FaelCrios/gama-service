package com.tcc.gamaservice.controller;

import com.tcc.gamaservice.service.GamaService;
import io.micrometer.observation.annotation.Observed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class GamaController {

    @Autowired
    GamaService service;

    @GetMapping("/gama")
    @Observed(
            name = "user.name",
            contextualName = "gama-->service",
            lowCardinalityKeyValues = {"userType", "userType2"}
    )
    public String comunicacaoModulos(){
        log.info("Serviço gama foi chamado");
        return service.createFunction();
    }

}
