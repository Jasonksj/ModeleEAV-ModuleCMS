package com.example.modeleEAV.controllers;

import com.example.modeleEAV.services.AttributValuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/attributeValues")
public class AttributValuesController {
    AttributValuesService attributValuesService;

    @Autowired
    public AttributValuesController(AttributValuesService attributValuesService){
        this.attributValuesService = attributValuesService;
    }


}
