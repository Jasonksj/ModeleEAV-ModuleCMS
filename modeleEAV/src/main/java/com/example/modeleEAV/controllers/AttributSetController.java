package com.example.modeleEAV.controllers;

import com.example.modeleEAV.models.utilitiesEAV.AttributeSet;
import com.example.modeleEAV.services.AttributeSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/attributeSet/")
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
    public List<AttributeSet> registerNewAttribute(@RequestBody AttributeSet attributeSet){
        attributeSetService.addAttributeSet(attributeSet);
        return attributeSetService.getAttributeSet();
    }

    @DeleteMapping(path = "{attributeSetId}")
    public String DeleteAttributeSet(@PathVariable("attributeSetId") Long attributeSetId){
        attributeSetService.deleteAttributeSet(attributeSetId);
        return "AttributSet " + attributeSetId + " supprimé avec succés" ;
    }

    @PutMapping(path = "{attributeSetId}")
    public List<AttributeSet> updateAttributeSet(
            @PathVariable("attributeSetId") Long attributeSetId,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) String titleSet,
            @RequestParam(required = false) String descriptionSet,
            @RequestParam(required = false) boolean shareable
    ) {
        attributeSetService.updateAttributSet(attributeSetId, title, description, titleSet, descriptionSet, shareable);
        return attributeSetService.getAttributeSet();
    }

    @GetMapping(path = "{title}")
    public AttributeSet FindAttributSetByTitle(@PathVariable("title") String title){
        return attributeSetService.findAttributeSetbyTitle(title);
    }

    @GetMapping(path = "{attributSetId}")
    public AttributeSet FindAttributSetById(@PathVariable("attributSetId") Long attributSetId){
        return attributeSetService.findAttributeSetbyId(attributSetId);
    }

    @GetMapping("{attributesId}/attributes")
    public Optional<AttributeSet> findAttributeSetbyAttributId(@PathVariable Long attributSetId) {
        return attributeSetService.findAttributeSetbyAttributId(attributSetId);
    }

}
