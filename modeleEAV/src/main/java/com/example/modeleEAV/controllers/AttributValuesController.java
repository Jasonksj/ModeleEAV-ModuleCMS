package com.example.modeleEAV.controllers;

import com.example.modeleEAV.models.DTO.AttributDTO;
import com.example.modeleEAV.models.DTO.AttributValuesDTO;
import com.example.modeleEAV.models.utilitiesEAV.Attribute;
import com.example.modeleEAV.models.utilitiesEAV.AttributeSet;
import com.example.modeleEAV.models.utilitiesEAV.AttributeValue;
import com.example.modeleEAV.services.AttributValuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/values")
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

    @DeleteMapping(path = "/attributeValues/{attributeValuesId}")
    public String DeleteAttributeValues(@PathVariable("attributeValuesId") UUID attributeValuesId){
        attributValuesService.deleteAttributeValues(attributeValuesId);
        return "AttributValues " + attributeValuesId + " supprimé avec succés" ;
    }

    @PutMapping(path = "/attributeValues/{attributeValuesId}")
    public ResponseEntity<Void> updateAttributeValues(
            @PathVariable("attributeValuesId") UUID attributeValuesId,
            @RequestBody AttributValuesDTO attributValuesDTO
    ) {
        attributValuesService.updateAttributValues(attributeValuesId, attributValuesDTO);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/attributesValues/{title}")
    public AttributeValue FindAttributValuesByTitle(@PathVariable("title") String title){
        return attributValuesService.findAttributeValuesbyTitle(title);
    }

}
