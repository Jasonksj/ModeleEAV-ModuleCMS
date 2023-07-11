package com.SamyBodio.AEVCms.Controller;

import com.SamyBodio.AEVCms.Repository.AttributeRepository;
import com.SamyBodio.AEVCms.Service.EntityService;
import com.SamyBodio.AEVCms.model.Attribute;
import com.SamyBodio.AEVCms.model.AttributeValue;
import com.SamyBodio.AEVCms.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.SamyBodio.AEVCms.model.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/attr")
public class EntityController {
    private final EntityService entityService;
    private final AttributeRepository attributeRepository;

    @Autowired
    public EntityController(EntityService entityService,
                            AttributeRepository attributeRepository){
        this.entityService = entityService;
        this.attributeRepository = attributeRepository;
    }

    @PostMapping
    public ResponseEntity<String> CreateAttribute(@RequestBody Attribute attribute,
                                                  @RequestParam("userName") String userName, @RequestParam("userPwd") String userPwd) {
        System.out.println(attribute+" "+userName+" "+userPwd);
        User user = new User(userName,userPwd);
        AttributeValue attributeValue = attribute.getDefinedValues().get(0);
        entityService.CreateAttributes(user, attribute, attributeValue);
        return ResponseEntity.ok("Insertion réussie");
    }
    @GetMapping("/attributeV")
    public List<AttributeValue> GetAttributeValues(@RequestParam String titleAttribute){
        return entityService.getAttributesValues(titleAttribute);
    }
    @PutMapping("/update")
    public ResponseEntity<String> updateAttribute(@RequestBody Attribute attribute,@RequestParam String title){
        entityService.updateAttribute(attribute,title);
        return ResponseEntity.ok("Mise a jour reussit avec success");
    }
    @GetMapping
    public List<Attribute> GetAttributes(){
        return entityService.getAttributes();
    }
    @GetMapping(path = "/search/{Str}")
    public List<Attribute> SearchAttributes(@PathVariable String Str){
        return entityService.SearchAttributes(Str);
    }

    @DeleteMapping(path = "/delete/{Str}")
    public ResponseEntity<String> DeleteAttribute(@PathVariable String Str){
        entityService.DeleteAttributes(Str);
        return ResponseEntity.ok("Suppression réussie");
    }

    @PutMapping(path = "/entity")
    public ResponseEntity<String> addEntityInAttribute(@RequestParam String str, @RequestBody List<Entity>  entity){
        entityService.addEntityInAttribute(str,entity);
        return ResponseEntity.ok("Insertion reussi");
    }

    @GetMapping(path = "/entity-type/{str}")
    public List<Entity> GetEntityInAttribute(@PathVariable UUID str){
        return entityService.getEntityInAttribute(str);
    }
    @PostMapping(path = "/set_attr/{set}")
    public ResponseEntity<String> createAttr(@PathVariable AttributeSet attrSet){
        entityService.createAttributeSet(attrSet);
        return ResponseEntity.ok("Creation réussie");
    }
    @DeleteMapping(path = "/delete_attr/{set}")
    public ResponseEntity<String> deleteAttrSet(@PathVariable UUID attrSet){
        entityService.deleteAttributeSet(attrSet);
        return ResponseEntity.ok("Suppression réussie");
    }
    @PutMapping(path = "/update_attr/{set}")
    public ResponseEntity<String> updateAttrSet(@PathVariable UUID attrSet){
        entityService.updateAttributeSet(attrSet);
        return ResponseEntity.ok("Modification réussie");
    }
    @GetMapping(path = "/get_attrSets/{set}")
    public List<AttributeSet>  GetAllAttributeSet(@PathVariable UUID attrSet){
        return entityService.getAllAttributeSet(attrSet);
    }
    @GetMapping(path = "/get_attrSet_info/{set}")
    public AttributeSet  GetAttributeSetInfo(@PathVariable UUID attrSet){
        return entityService.getAttributeSetInfo(attrSet);
    }
    @GetMapping(path = "/attrSet/attributes/{set}")
    public List<Attribute> GetAttributeSetAttributes(@PathVariable UUID attrSet){
        return entityService.getAttributeSetAttributes(attrSet);
    }

    /*----------------------------------Entity - Attribute---------------------------------------*/
    @GetMapping(path = "/entityAttr/{entity}")
    public List<Entity> GetEntitiesOfAttribute(@PathVariable UUID attr){
        return entityService.getEntitiesOfAttribute(attr);
    }
    @PutMapping(path = "/entityAttr/{entity}")
    public ResponseEntity<String> addAttrInEntity(@PathVariable UUID attr){
        entityService.addAttrInEntity(attr);
        return ResponseEntity.ok("Mise a jour reussi");
    }
    @DeleteMapping(path = "/entityAttr/{entity}")
    public ResponseEntity<String> deleteAttrInEntity(@PathVariable UUID attr){
        entityService.deleteAttrInEntity(attr);
        return ResponseEntity.ok("Suppression réussie");
    }

}
