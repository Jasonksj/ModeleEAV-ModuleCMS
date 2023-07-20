package com.example.modeleEAV.controllers;

import com.example.modeleEAV.models.DTO.AttributSetDTO;
import com.example.modeleEAV.models.utilitiesEAV.AttributeSet;
import com.example.modeleEAV.services.AttributeSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/attributeSet")
public class AttributSetController {
    AttributeSetService attributeSetService;

    @Autowired
    public AttributSetController(AttributeSetService attributeSetService)
    {
        this.attributeSetService = attributeSetService;
    }

    @GetMapping()
    public List<AttributeSet> getAttributeSet(){
        return attributeSetService.getAttributeSet();
    }

    @PostMapping
    public List<AttributeSet> registerNewAttributeSet(@RequestBody AttributeSet attributeSet){
        attributeSetService.addAttributeSet(attributeSet);
        return attributeSetService.getAttributeSet();
    }

    @DeleteMapping(path = "{attributeSetId}")
    public String DeleteAttributeSet(@PathVariable("attributeSetId") UUID attributeSetId){
        attributeSetService.deleteAttributeSet(attributeSetId);
        return "AttributSet " + attributeSetId + " supprimé avec succés" ;
    }

    @PutMapping(path = "{attributeSetId}")
    public ResponseEntity<String> updateAttributeSet(
            @PathVariable("attributeSetId") UUID attributeSetId,
            @RequestBody AttributSetDTO attributSetDTO
            ) {
        attributeSetService.updateAttributSet(attributeSetId, attributSetDTO);
        return ResponseEntity.ok("Mise a jour Reussi");
    }



    @GetMapping(path = "{attributSetId}")
    public AttributeSet FindAttributSetById(@PathVariable("attributSetId") UUID attributSetId){
        return attributeSetService.findAttributeSetbyId(attributSetId);
    }

  

}
