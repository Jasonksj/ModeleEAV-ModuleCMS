package com.example.modeleEAV.controllers;

import com.example.modeleEAV.models.DTO.AttributDTO;
import com.example.modeleEAV.models.utilitiesEAV.Attribute;
import com.example.modeleEAV.models.utilitiesEAV.AttributeType;
import com.example.modeleEAV.services.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api")
public class AttributeController {
    private AttributeService attributeService;

    @Autowired
    public AttributeController(AttributeService attributeService){
        this.attributeService = attributeService;
    }

    @GetMapping("/attributes")
    public List<Attribute> getAttributes(){
        return attributeService.getAttributes();
    }

    @GetMapping(path = "/search/{Str}")
    public List<Attribute> SearchAttributes(@PathVariable String Str){
        return attributeService.SearchAttributes(Str);
    }
    @PostMapping
    public List<Attribute> registerNewAttribut(@RequestBody Attribute attribute){
        attributeService.addAttribute(attribute);
        return attributeService.getAttributes();
    }

    @DeleteMapping(path = "/attributes/{attributeId}")
    public String DeleteAttribute(@PathVariable("attributeId") UUID attributeId){
        attributeService.deleteAttribute(attributeId);
        return "Attribut " + attributeId + " supprimé avec succés" ;
    }

    @PutMapping(path = "/attributes/{attributeId}")
    public ResponseEntity<Void> updateAttribute(
            @PathVariable("attributeId") UUID attributeId,
            @RequestBody AttributDTO attributDTO
    ) {
        attributeService.updateAttribut(attributeId, attributDTO);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/attributes/{title}")
    public Attribute FindAttributByTitle(@PathVariable("title") String title){
        return attributeService.findAttributebyTitle(title);
    }

    @GetMapping(path = "/attribute/{attributeId}")
    public Attribute FindAttributById(@PathVariable("attributeId") UUID attributeId){
        return attributeService.findAttributebyId(attributeId);
    }

    @GetMapping(path = "/attribut/{attributeId}")
    public List<Attribute> getAttributesByAttributeSetId(@PathVariable("attributeId") UUID attributeSetId) {
        return attributeService.getAttributesByAttributeSetId(attributeSetId);
    }

}
