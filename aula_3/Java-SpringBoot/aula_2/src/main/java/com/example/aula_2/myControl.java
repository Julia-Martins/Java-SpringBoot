package com.example.aula_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class myControl {

    @Autowired
    private String nameApplication;

    @Autowired
    @Qualifier("versionApplication")
    private String version;

    @GetMapping(value="nameApplicationObtain")
    public String getNameApplication() {
        return nameApplication;
    }

    @GetMapping(value="versionApplicationObtain")
    public String getVersionApplication() {
        return version;
    }
    
    
}
