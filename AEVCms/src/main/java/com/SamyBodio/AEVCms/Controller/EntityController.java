package com.SamyBodio.AEVCms.Controller;

import com.SamyBodio.AEVCms.Service.EntityService;
import com.SamyBodio.AEVCms.model.Attribute;
import com.SamyBodio.AEVCms.model.AttributeValue;
import com.SamyBodio.AEVCms.model.entity.User;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.SamyBodio.AEVCms.model.*;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@RestController
@RequestMapping("api/attr")
public class EntityController {
    public static final String REUSSIE = "Suppression réussie";
    @Autowired
    private EntityService entityService;

    /*--------------------attribute--------------*/
    @PostMapping
    public ResponseEntity<String> createAttribute(@RequestBody Attribute attribute,
                                                  @RequestParam("userName") String userName,
                                                  @RequestParam("userPwd") String userPwd) {
        User user = new User(userName,userPwd);
        entityService.CreateAttributes(user, attribute);
        return ResponseEntity.ok("Insertion réussie");
    }
    @GetMapping
    public List<Attribute> getAttributes(){
        return entityService.getAttributes();
    }
    @GetMapping(path = "/search/{Str}")
    public List<Attribute> searchAttributes(@PathVariable String Str){
        return entityService.SearchAttributes(Str);
    }
    @DeleteMapping(path = "/delete/{str}")
    public ResponseEntity<String> deleteAttribute(@PathVariable UUID str){
        entityService.DeleteAttributes(str);
        return ResponseEntity.ok(REUSSIE);
    }
    @PutMapping("/update")
    public ResponseEntity<String> updateAttribute(@RequestBody Attribute attribute,@RequestParam UUID ID){
        entityService.updateAttribute(attribute,ID);
        return ResponseEntity.ok("Mise a jour reussit avec success");
    }
    /*----------------attributeValue-------------*/
    @GetMapping("/attributeV")
    public List<AttributeValue> getAttributeValuesOfAttribute(@RequestParam UUID ID){
        return entityService.getAttributesValuesOfAttributes(ID);
    }
    @PutMapping("addAttrVInAttr/{idSet}")
    public ResponseEntity<String> addAttributeValueInAttribute(@PathVariable("idSet") UUID ID,@RequestBody List<AttributeValue> attributeValues){
        entityService.addAttributeValueInAttribute(ID,attributeValues);
        return ResponseEntity.ok("Update Reussi");
    }

    /*---------------------------attributeSet-------------------------------*/
    @PostMapping(path = "/created_set_attr")
    public ResponseEntity<String> createAttrSet(@RequestBody AttributeSet attrSet,
                                                @Nullable @RequestParam String name,
                                                @Nullable @RequestParam String pwd)
    {
        entityService.createAttributeSet(attrSet,name,pwd);
        return ResponseEntity.ok("Creation réussie");
    }
    @DeleteMapping(path = "/delete_attr/{set}")
    public ResponseEntity<String> deleteAttrSet(@PathVariable("set") UUID attrSet){
        entityService.deleteAttributeSet(attrSet);
        return ResponseEntity.ok(REUSSIE);
    }
    @PutMapping(path = "/updateAttrSet/{set}")
    public ResponseEntity<String> updateAttrSet(@PathVariable("set") UUID attrSet,@RequestBody AttributeSet attributeSet){
        entityService.updateAttributeSet(attrSet,attributeSet);
        return ResponseEntity.ok("Modification réussie");
    }
    @GetMapping(path = "/get_attrSets")
    public List<AttributeSet> getAllAttributeSet(){
        return entityService.getAllAttributeSet();
    }
    @GetMapping(path = "/attrSet/attributes/{set}")
    public List<Attribute> getAttributesOfAttributeSet(@PathVariable("set") UUID attrSet){
        return entityService.getAttributeSetAttributes(attrSet);
    }
    @PutMapping("/attrSet/addAttrInAttrSet/{set}")
    public ResponseEntity<String> addAttributesInAttributeSet(@PathVariable("set") UUID set,@RequestBody List<Attribute> attributes){
        entityService.addAttrInAttrSet(set,attributes);
        return ResponseEntity.ok("Insertion reussi");
    }
    @GetMapping(path = "/get_attrSet_info/{set}")
    public AttributeSet getAttributeSetInfo(@PathVariable UUID attrSet){
        return entityService.getAttributeSetInfo(attrSet);
    }


    /*----------------------------------Entity Type---------------------------------------*/
    @GetMapping(path = "/getEntitiesTypeOfAttribute/{Id}")
    public List<Entity_Type> getEntitiesTypeOfAttribute(@PathVariable("Id") UUID attributeId) throws Exception {
        return entityService.getEntitiesTypeOfAttribute(attributeId);
    }

    @PutMapping(path ="/addEntityTypeInAttribute/{Id}")
    public ResponseEntity<String> addEntityTypeInAttribute(@PathVariable("Id") UUID attributeId,@RequestBody Entity_Type entityType) throws Exception {
        entityService.addEntityTypeInAttribute(attributeId, entityType);
        return ResponseEntity.ok("Ajout reussi");
    }

    @PutMapping(path = "/removeEntityTypeFromAttribute/{IdAttribute}/{IdEntityType}")
    public ResponseEntity<String> removeEntityTypeFromAttribute(@PathVariable("IdAttribute") UUID attributeId,
                                                                @PathVariable("IdEntityType") UUID EntityTypeId) throws Exception {
        entityService.removeEntityTypeFromAttribute(attributeId,EntityTypeId);
        return ResponseEntity.ok("Suppression reussi");
    }

    @PostMapping(path = "/createEntityType")
    public ResponseEntity<String> createEntityType(@RequestBody Entity_Type EntityType){
        entityService.createEntityType(EntityType);
        return ResponseEntity.ok("Creation reussi");
    }

    @GetMapping(path="/getAllEntityType")
    public List<Entity_Type> getAllEntityType(){
        return entityService.getAllEntityType();
    }
    @GetMapping(path="/getAttributesOfEntityType/{Id}")
    public List<Attribute> getAttributesOfEntityType(@PathVariable("Id") UUID EntityTypeId) throws Exception {
        return entityService.getAttributesOfEntityType(EntityTypeId);
    }

    @PutMapping(path = "/addAttributeInEntityType/{Id}")
    public ResponseEntity<String> addAttributeInEntityType(@PathVariable("Id") UUID EntityTypeId,@RequestBody Attribute attribute) throws Exception {
        entityService.addAttributeInEntityType(EntityTypeId,attribute);
        return ResponseEntity.ok("Ajout reussi avec success");
    }
    @PutMapping(path="/removeAttributeFromEntityType/{Id}")
    public ResponseEntity<String> removeAttributeFromEntityType(@PathVariable("Id") UUID EntityTypeId,@RequestParam UUID AttributeId) throws Exception {
        entityService.removeAttributeFromEntityType(EntityTypeId,AttributeId);
        return ResponseEntity.ok("suppression reussi");
    }

    /*-------------------------------------Entity--------------------------------------------*/

    @GetMapping(path = "/getEntitiesOfAttribute/{Id}")
    public List<Entity> getEntitiesOfAttribute(@PathVariable("Id") UUID attributeId) throws Exception {
        return entityService.getEntitiesOfAttribute(attributeId);
    }
    @PutMapping(path = "/addEntityInAttribute/{Id}")
    public ResponseEntity<String> addEntityInAttribute(@PathVariable("Id") UUID attributeId,@RequestBody Entity entity) throws Exception {
        entityService.addEntityInAttribute(attributeId,entity);
        return ResponseEntity.ok("Mise a jour reussi");
    }
    @DeleteMapping(path ="/removeEntityFromAttribute/{Id}" )
    public ResponseEntity<String> removeEntityFromAttribute(@PathVariable("Id") UUID attributeId, @RequestParam UUID EntityId) throws Exception {
        entityService.removeEntityFromAttribute(attributeId,EntityId);
        return ResponseEntity.ok("Suppression reussie");
    }
    @GetMapping(path="/getAttributesOfEntity/{Id}")
    public List<Attribute>  getAttributesOfEntity(@PathVariable("Id") UUID EntityId) throws Exception {
        return entityService.getAttributesOfEntity(EntityId);
    }
    @PutMapping(path = "/addAttributeInEntity/{Id}")
    public ResponseEntity<String> addAttributeInEntity(@PathVariable("Id") UUID EntityId,@RequestBody Attribute attribute) throws Exception {
        entityService.addAttributeInEntity(EntityId,attribute);
        return ResponseEntity.ok("Ajout reussi");
    }
    @DeleteMapping(path = "/removeAttributeFromEntity/{Id}")
    public ResponseEntity<String> removeAttributeFromEntity(@PathVariable("Id") UUID EntityId,@RequestParam UUID attributeId) throws Exception {
        entityService.removeAttributeFromEntity(EntityId,attributeId);
        return ResponseEntity.ok("Suppression Reussi");
    }
}
