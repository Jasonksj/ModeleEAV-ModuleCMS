package com.SamyBodio.AEVCms.Controller;

import com.SamyBodio.AEVCms.Service.EntityService;
import com.SamyBodio.AEVCms.model.Attribute;
import com.SamyBodio.AEVCms.model.AttributeValue;
import com.SamyBodio.AEVCms.model.entity.User;
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
        Logger.getLogger(attribute.get_Id()+" "+attribute+" "+attribute.getDefinedValues().get(0).get_Id());
        User user = new User(userName,userPwd);
        entityService.CreateAttributes(user, attribute,attribute.getDefinedValues());
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
    public ResponseEntity<String> createAttrSet(@RequestBody AttributeSet attrSet,@RequestParam String name,@RequestParam String pwd){
        entityService.createAttributeSet(attrSet,name,pwd);
        return ResponseEntity.ok("Creation réussie");
    }
    @DeleteMapping(path = "/delete_attr/{set}")
    public ResponseEntity<String> deleteAttrSet(@PathVariable("set") UUID attrSet){
        entityService.deleteAttributeSet(attrSet);
        return ResponseEntity.ok(REUSSIE);
    }
    @PutMapping(path = "/update_attr/{set}")
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
    /*----------------------------------Entity - Attribute---------------------------------------*/

    @PutMapping(path = "/entity")
    public ResponseEntity<String> addEntityInAttribute(@RequestParam UUID str, @RequestBody List<Entity>  entity){
        entityService.addEntityInAttribute(str,entity);
        return ResponseEntity.ok("Insertion reussi");
    }//false

    @GetMapping(path = "/entity/{str}")
    public List<Entity> getEntityInAttribute(@PathVariable UUID str){
        return entityService.getEntityInAttribute(str);
    }
    @DeleteMapping(path ="/entity/{str}" )
    public ResponseEntity<String> deleteEntityInAttribute(@PathVariable UUID attribute, @RequestParam String Entity){
        entityService.deleteEntityInAttribute(attribute,Entity);
        return ResponseEntity.ok("Suppression reussie");
    }//false
    @GetMapping(path = "/entityAttr/{entity}")
    public List<Entity> getEntitiesOfAttribute(@PathVariable UUID attr){
        return entityService.getEntitiesOfAttribute(attr);
    }
    @PutMapping(path = "/entityAttr/{entity}")
    public ResponseEntity<String> addAttrInEntity(@PathVariable UUID IdEntity,@RequestParam Attribute attribute){
        entityService.addAttrInEntity(IdEntity,attribute);
        return ResponseEntity.ok("Mise a jour reussi");
    }
    @DeleteMapping(path = "/entityAttr/{entity}")
    public ResponseEntity<String> deleteAttrInEntity(@PathVariable UUID attr,@RequestParam String str){
        entityService.deleteAttrInEntity(attr,str);
        return ResponseEntity.ok(REUSSIE);
    }

}
