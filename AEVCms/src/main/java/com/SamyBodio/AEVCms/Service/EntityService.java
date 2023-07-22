package com.SamyBodio.AEVCms.Service;

import com.SamyBodio.AEVCms.Repository.*;
import com.SamyBodio.AEVCms.model.*;
import com.SamyBodio.AEVCms.model.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EntityService {
    public static final String NOT_EXISTS = " does not exists";
    public static final String EMPTY = "IsEmpty";
    @Autowired
    private AttributeValueRepository attributeValueRepository;
    @Autowired
    private AttributeRepository attributeRepository;
    @Autowired
    private AttributeSetRepository attributeSetRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EntityRepository entityRepository;

    @Autowired
    private EntityTypeRepository entityTypeRepository;
    //1
    @Transactional
    public void CreateAttributes(User user, Attribute attribute,List<AttributeValue>  attributeValue) {
        attribute.setCreateBy(user);
        for(AttributeValue attributeValue1: attributeValue){
           attributeValue1.setAttribute(attribute);
        }
        attribute.addPredifinedValues(attributeValue);
        attributeRepository.save(attribute);
    }
    //2
    public List<Attribute> getAttributes() {
        return attributeRepository.findAll();
    }
    //3 ame
    public List<Attribute> SearchAttributes(String str) {
        return attributeRepository.findAll().stream().filter(S-> S.getTitle().getFrench().contains(str) ||
                S.getTitle().getEnglish().contains(str) ||
                S.getDescription().getFrench2().contains(str)||
                S.getDescription().getEnglish2().contains(str) ||
                S.getCreateBy().toString().contains(str)).toList();
    }
    //j'ai envoye le dossier de Tstring2 sur Telegram recupere le de ton cote et met le dans Entity
    //4
    @Transactional
    public void DeleteAttributes(UUID id) {
        attributeRepository.deleteById(id);
    }
    //5
    public List<AttributeValue> getAttributesValuesOfAttributes(UUID uuid) {
        Optional<Attribute> optionalAttribute = attributeRepository.findById(uuid);
        if(optionalAttribute.isEmpty()){
            throw new IllegalStateException("Attribute with title "+uuid+ NOT_EXISTS);
        }
        return optionalAttribute.get().getDefinedValues();
    }
    //6
    @Transactional
    public void updateAttribute(Attribute attribute, UUID ID) {
        Optional<Attribute> optionalAttribute = attributeRepository.findById(ID);
        if(optionalAttribute.isEmpty()){
            throw new IllegalStateException("Attribute with ID "+ID+ NOT_EXISTS);
        }
        Attribute attribute1 = optionalAttribute.get();
        attribute1.setUpdateAt(LocalDate.now());
        attribute1.setHerited(attribute.getHerited());
        attribute1.setDeleteAt(attribute.getDeleteAt());
        attribute1.setDefinedValues(attribute.getDefinedValues());
        attribute1.setFreezeValues(attribute.getFreezeValues());
        attribute1.setMultipleValues(attribute.getMultipleValues());
        attribute1.setMeasurable(attribute.getMeasurable());
        attribute1.setRequiredValue(attribute.getRequiredValue());
        attribute1.setOverriden(attribute.getOverriden());
        attribute1.setType(attribute.getType());
        attribute1.setTitle(attribute.getTitle());
        attribute1.setDescription(attribute.getDescription());
        attribute1.setShared(attribute.getShared());
        attributeRepository.save(attribute1);
    }
    /*
    //7
    @Modifying
    @Transactional
    public void addEntityInAttribute(UUID id,@NonNull List<Entity> entities) {
        Optional<Attribute> Opt = attributeRepository.findById(id);
        if(Opt.isEmpty()){
            throw new IllegalStateException("Attribute with Id "+id+ NOT_EXISTS);
        }
        Attribute attribute = Opt.get();

            entityRepository.saveAll(entities);
            attribute.setEntities(entities);
            attributeRepository.save(attribute);

    }*/

    /*
    //8
    public List<Entity> getEntityInAttribute(UUID str) {
        Optional<Attribute> Opt = attributeRepository.findById(str);
        if(Opt.isEmpty()){
            throw new IllegalStateException("Attribute with title "+str+ NOT_EXISTS);
        }
        return Opt.get().getEntities();
    }
    */
    //9
    public void createAttributeSet(AttributeSet attrSet, String name, String pwd) {
        User user = new User(name,pwd);
        attrSet.setCreateBy(user);
        attrSet.setDeleteBy(user);
        attrSet.setUpdateBy(user);
        attributeSetRepository.save(attrSet);
    }

    public void deleteAttributeSet(UUID attrSet) {
       Optional<AttributeSet>Opt = attributeSetRepository.findById(attrSet);
       if(Opt.isEmpty()){
           throw new IllegalStateException("Attribute with ID "+attrSet+ NOT_EXISTS);
       }
       attributeSetRepository.delete(Opt.get());
    }

    public void updateAttributeSet(UUID attrSet, AttributeSet attributeSet) {
        Optional<AttributeSet>Opt = attributeSetRepository.findById(attrSet);
        if (Opt.isEmpty()){
            throw new IllegalStateException("Is Empty");
        }
        AttributeSet attributeSet1 = Opt.get();
        attributeSet1.getTitle().setFrench(attributeSet.getTitle().getFrench());
        attributeSet1.getTitle().setEnglish(attributeSet.getTitle().getEnglish());
        attributeSet1.getDescription().setFrench2(attributeSet.getDescription().getFrench2());
        attributeSet1.getDescription().setEnglish2(attributeSet.getDescription().getEnglish2());
        attributeSet1.setShareable(attributeSet.getShareable());
        attributeSetRepository.save(attributeSet);
    }

    public List<AttributeSet> getAllAttributeSet() {
        return attributeSetRepository.findAll();
    }

    public AttributeSet getAttributeSetInfo(UUID attrSet) {
        Optional<AttributeSet>Opt = attributeSetRepository.findById(attrSet);
        if(Opt.isEmpty()){
            throw new IllegalStateException(EMPTY);
        }
        return Opt.get();
    }

    public List<Attribute> getAttributeSetAttributes(UUID attrSet) {
        Optional<AttributeSet>Opt = attributeSetRepository.findById(attrSet);
        if(Opt.isEmpty()){
            throw new IllegalStateException(EMPTY);
        }
        return Opt.get().getAttributes();
    }

    public List<Entity_Type> getAttributeEntity_type(UUID attribut) {
        Optional<Attribute> Opt = attributeRepository.findById(attribut);
        if(Opt.isEmpty()){
            throw new IllegalStateException(EMPTY);
        }
        return Opt.get().getEntityTypeList();
    }

    @Transactional
    public void deleteEntity_typeinAttribut(UUID attribut, UUID entity_type) {
        Optional<Entity_Type> Opt = entityTypeRepository.findById(entity_type);
        Optional<Attribute>Opt2 = attributeRepository.findById(attribut);
        if(Opt2.isEmpty() || Opt.isEmpty()){
            throw new IllegalStateException(EMPTY);
        }
        Entity_Type entity1 = Opt.get();
        Attribute attribute = Opt2.get();
        attribute.getEntityTypeList().remove(entity1);
        entityTypeRepository.save(entity1);
    }

    @Transactional
    public void addEntity_tyêInAttribut(UUID attribut, Entity_Type entity_type) {
        Optional<Attribute> Opt = attributeRepository.findById(attribut);
        if(Opt.isEmpty()){
            throw new IllegalStateException(EMPTY);
        }
        Opt.get().getEntityTypeList().add(entity_type);
        entityRepository.save(Opt.get());
    }

    /*
    public List<Entity> getEntitiesOfAttribute(UUID attr) {
        Optional<Attribute>Opt = attributeRepository.findById(attr);
        if(Opt.isEmpty()){
            throw new IllegalStateException(EMPTY);
        }
        return Opt.get().getEntities();
    }

    /*@Transactional
    public void addAttrInEntity(UUID entity, Attribute attribute) {
        Optional<Entity> Opt = entityRepository.findById(entity);
        if(Opt.isEmpty()){
            throw new IllegalStateException(EMPTY);
        }
        Opt.get().getAttributes().add(attribute);
        entityRepository.save(Opt.get());
    }

    @Transactional
    public void deleteAttrInEntity(UUID entity, String title) {
        Optional<Entity> Opt = entityRepository.findById(entity);
        Optional<Attribute>Opt2 = attributeRepository.findByTitle(title);
        if(Opt2.isEmpty() || Opt.isEmpty()){
            throw new IllegalStateException(EMPTY);
        }
        Entity entity1 = Opt.get();
        Attribute attribute = Opt2.get();
        entity1.getAttributes().remove(attribute);
        entityRepository.save(entity1);
    }

    public List<Attribute> getAttributesOfEntity(UUID entity) {
        Optional<Entity> Opt = entityRepository.findById(entity);
        if(Opt.isEmpty()){
            throw new IllegalStateException(EMPTY);
        }
        Entity entity1 = Opt.get();
        return entity1.getAttributes();
    }

    public void deleteEntityInAttribute(UUID entity, String attribute) {
        Optional<Attribute> Opt = attributeRepository.findByTitle(attribute);
        Optional<Entity>Opt2 = entityRepository.findById(entity);
        if(Opt2.isEmpty() || Opt.isEmpty()){
            throw new IllegalStateException(EMPTY);
        }
        Attribute attribute1 = Opt.get();
        Entity entity1 = Opt2.get();
        attribute1.getEntities().remove(entity1);
        attributeRepository.save(attribute1);
    }*/

    //9
    @Modifying
    @Transactional
    public void  addAttrInAttrSet(UUID setId, List<Attribute> attributes) {
        Optional<AttributeSet> opt = attributeSetRepository.findById(setId);
        if (opt.isEmpty()) {
            throw new IllegalStateException(EMPTY);
        }
        AttributeSet attributeSet = opt.get();
        for (Attribute attribute : attributes) {
            attribute.setAttributeSet(attributeSet);
        }
        attributeSet.getAttributes().addAll(attributes);
        attributeSetRepository.save(attributeSet);
    }

    public void addAttributeValueInAttribute(UUID id, List<AttributeValue> attributeValues) {
        Optional<Attribute> Opt = attributeRepository.findById(id);
        if (Opt.isEmpty()) {
            throw new IllegalStateException(EMPTY);
        }
        Attribute attribute = Opt.get();
        for (AttributeValue attributeValue: attributeValues){
            attributeValue.setAttribute(attribute);
        }
        attribute.getDefinedValues().addAll(attributeValues);
        attributeRepository.save(attribute);
    }
}
