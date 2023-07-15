package com.example.modeleEAV.controllers;

import com.example.modeleEAV.models.utilitiesEAV.Attribute;
import com.example.modeleEAV.models.utilitiesEAV.AttributeSet;
import com.example.modeleEAV.models.utilitiesEAV.AttributeValue;
import com.example.modeleEAV.services.AttributValuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/attributeValues")
public class AttributValuesController {
    AttributValuesService attributValuesService;

    @Autowired
    public AttributValuesController(AttributValuesService attributValuesService){
        this.attributValuesService = attributValuesService;
    }

    @GetMapping("/attributeValues")
    public List<AttributeValue> getAttributeValues(){
        return attributValuesService.getAttributeValues();
    }

    @PostMapping
    public List<AttributeValue> registerNewAttributeValue(@RequestBody AttributeValue attributeValue){
        attributValuesService.addAttributeValues(attributeValue);
        return attributValuesService.getAttributeValues();
    }

}
