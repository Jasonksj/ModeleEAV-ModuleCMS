package com.example.modeleEAV.controllers;

import com.example.modeleEAV.models.utilitiesEAV.Attribute;
import com.example.modeleEAV.models.utilitiesEAV.AttributeType;
import com.example.modeleEAV.services.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping
    public List<Attribute> registerNewAttribute(@RequestBody Attribute attribute){
        attributeService.addAttribute(attribute);
        return attributeService.getAttributes();
    }

    @DeleteMapping(path = "/attributes/{attributeId}")
    public String DeleteAttribute(@PathVariable("attributeId") Long attributeId){
        attributeService.deleteAttribute(attributeId);
        return "Attribut " + attributeId + " supprimé avec succés" ;
    }

    @PutMapping(path = "/attributes/{attributeId}")
    public List<Attribute> updateAttribute(
            @PathVariable("attributeId") Long attributeId,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) AttributeType type,
            @RequestParam(required = false) boolean requiredValue,
            @RequestParam(required = false) boolean multipleValues,
            @RequestParam(required = false) boolean freezeValues,
            @RequestParam(required = false) boolean overriden,
            @RequestParam(required = false) boolean shareable,
            @RequestParam(required = false) boolean shared,
            @RequestParam(required = false) boolean measurable,
            @RequestParam(required = false) boolean isEntityDedicated
    ) {
        attributeService.updateAttribut(attributeId, title, description,type, requiredValue, multipleValues, freezeValues, overriden, shareable, shared, measurable, isEntityDedicated);
        return attributeService.getAttributes();
    }

    @GetMapping(path = "/attributes/{title}")
    public Attribute FindAttributByTitle(@PathVariable("title") String title){
        return attributeService.findAttributebyTitle(title);
    }

    @GetMapping(path = "/attribute/{attributeId}")
    public Attribute FindAttributById(@PathVariable("attributeId") Long attributeId){
        return attributeService.findAttributebyId(attributeId);
    }

    @GetMapping(path = "/attribut/{attributeId}")
    public List<Attribute> getAttributesByAttributeSetId(Long attributeSetId) {
        return attributeService.getAttributesByAttributeSetId(attributeSetId);
    }

}
