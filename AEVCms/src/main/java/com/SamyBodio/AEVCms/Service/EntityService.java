package com.SamyBodio.AEVCms.Service;

import com.SamyBodio.AEVCms.Repository.*;
import com.SamyBodio.AEVCms.model.*;
import com.SamyBodio.AEVCms.model.entity.User;
import jakarta.annotation.Nullable;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
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

    @Transactional
    public void CreateAttributes(User user, Attribute attribute) {
        attribute.setCreateBy(user);
        List<AttributeValue> attributeValue = attribute.getDefinedValues();
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
        //System.out.println();
        return attributeRepository.findAll().stream().filter(
                s -> s.toString().contains(str) ||
                s.getTitle().toString().contains(str) ||
                s.getDescription().toString().contains(str) ||
                s.getCreateBy().toString().contains(str)).toList() ;
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

    //9
    public void createAttributeSet(AttributeSet attrSet, @Nullable String name,@Nullable String pwd) {
        User user = new User(name,pwd);
        attrSet.setCreateBy(user);
        attrSet.setDeleteBy(user);
        attrSet.setUpdateBy(user);
        List<Attribute> attributes = attrSet.getAttributes();
        for (Attribute attribute:attributes) {
            attribute.setAttributeSet(attrSet);
        }
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
        attributeSet1.getTitle().setFr(attributeSet.getTitle().getFr());
        attributeSet1.getTitle().setEn(attributeSet.getTitle().getEn());
        attributeSet1.getDescription().setFr(attributeSet.getDescription().getFr());
        attributeSet1.getDescription().setEn(attributeSet.getDescription().getEn());
        attributeSet1.setShareable(attributeSet.getShareable());
        attributeSet1.setAttributes(attributeSet.getAttributes());
        attributeSetRepository.save(attributeSet1);
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
/*-------------------------------------------------------------------*/
    public void addEntityInAttribute(UUID attributeId, Entity entity) throws Exception {
        Optional<Attribute> Opt = attributeRepository.findById(attributeId);
        if (Opt.isEmpty()){
            throw new Exception("Attribute with id "+attributeId+" is not present");
        }
        Attribute attribute = Opt.get();
        attribute.getEntityList().add(entity);
        entity.getAttributeList().add(attribute);
        attributeRepository.save(attribute);
    }

    public void removeEntityTypeFromAttribute(UUID attributeId, UUID entityTypeId) throws Exception {
        Optional<Attribute> Opt = attributeRepository.findById(attributeId);
        Optional<Entity_Type> OptE = entityTypeRepository.findById(entityTypeId);
        if (Opt.isEmpty() || OptE.isEmpty()){
            throw new Exception("Attribute with id "+attributeId+" is not present");
        }
        Attribute attribute = Opt.get();
        Entity_Type entityType = OptE.get();
        attribute.getEntityTypes().remove(OptE.get());
        entityType.getAttributes().remove(attribute);
        attributeRepository.save(attribute);
    }

    public void createEntityType(Entity_Type entityType) {
        for (Attribute attribute:entityType.getAttributes()) {
            attribute.getEntityTypes().add(entityType);
        }
        entityTypeRepository.save(entityType);
    }

    public List<Entity_Type> getAllEntityType() {
        return entityTypeRepository.findAll();
    }

    public void addAttributeInEntityType(UUID entityTypeId, Attribute attribute) throws Exception {
        Optional<Entity_Type> Opt = entityTypeRepository.findById(entityTypeId);
        if (Opt.isEmpty()){
            throw new Exception("EntityType with id "+entityTypeId+" is not present");
        }
        Entity_Type entity_type = Opt.get();
        entity_type.getAttributes().add(attribute);
        attribute.getEntityTypes().add(entity_type);
        entityTypeRepository.save(entity_type);
    }

    public void removeAttributeFromEntityType(UUID entityTypeId, UUID attributeId) throws Exception {
        Optional<Entity_Type> optionalEntityType = entityTypeRepository.findById(entityTypeId);
        Optional<Attribute> optionalAttribute = attributeRepository.findById(attributeId);
        if (optionalEntityType.isEmpty() || optionalAttribute.isEmpty()){
            throw new Exception("EntityType with id "+entityTypeId+" is not present");
        }
        Entity_Type entity_type = optionalEntityType.get();
        Attribute attribute = optionalAttribute.get();
        entity_type.getAttributes().remove(attribute);
        attribute.getEntityTypes().remove(entity_type);
        entityTypeRepository.save(entity_type);
    }

    public List<Entity> getEntitiesOfAttribute(UUID attributeId) throws Exception {
        Optional<Attribute> optionalAttribute = attributeRepository.findById(attributeId);
        if(optionalAttribute.isEmpty()){
            throw new Exception("Attribute with id "+attributeId+" is not present");
        }
        Attribute attribute = optionalAttribute.get();
        return attribute.getEntityList();
    }

    public void removeEntityFromAttribute(UUID attributeId, UUID entityId) throws Exception {
        Optional<Attribute> Opt = attributeRepository.findById(attributeId);
        Optional<Entity> OptE = entityRepository.findById(entityId);
        if (Opt.isEmpty() || OptE.isEmpty()){
            throw new Exception("Attribute or Entity id  is not present");
        }
        Attribute attribute = Opt.get();
        Entity entity = OptE.get();
        attribute.getEntityList().remove(OptE.get());
        entity.getAttributeList().remove(attribute);
        attributeRepository.save(attribute);
    }

    public void addEntityTypeInAttribute(UUID attributeId, Entity_Type entityType) throws Exception {
        Optional<Attribute> Opt = attributeRepository.findById(attributeId);
        if (Opt.isEmpty()){
            throw new Exception("Attribute with id "+attributeId+" is not present");
        }
        Attribute attribute = Opt.get();
        attribute.getEntityTypes().add(entityType);
        entityType.getAttributes().add(attribute);
        attributeRepository.save(attribute);
    }

    public List<Attribute> getAttributesOfEntity(UUID entityId) throws Exception {
        Optional<Entity> Opt = entityRepository.findById(entityId);
        if (Opt.isEmpty()){
            throw new Exception("Entity with Id "+entityId+" is not present");
        }
        Entity entity = Opt.get();
        return entity.getAttributeList();
    }

    public void addAttributeInEntity(UUID entityId, Attribute attribute) throws Exception {
        Optional<Entity> Opt = entityRepository.findById(entityId);
        if (Opt.isEmpty()){
            throw new Exception("Attribute with id "+entityId+" is not present");
        }
        Entity entity = Opt.get();
        entity.getAttributeList().add(attribute);
        attribute.getEntityList().add(entity);
        entityRepository.save(entity);
    }

    public void removeAttributeFromEntity(UUID entityId, UUID attributeId) throws Exception {
        Optional<Attribute> Opt = attributeRepository.findById(attributeId);
        Optional<Entity> OptE = entityRepository.findById(entityId);
        if (Opt.isEmpty() || OptE.isEmpty()){
            throw new Exception("Attribute or Entity id  is not present");
        }
        Attribute attribute = Opt.get();
        Entity entity = OptE.get();
        attribute.getEntityList().remove(OptE.get());
        entity.getAttributeList().remove(attribute);
        attributeRepository.save(attribute);
    }

    public List<Entity_Type> getEntitiesTypeOfAttribute(UUID attributeId) throws Exception {
        Optional<Attribute> optionalAttribute = attributeRepository.findById(attributeId);
        if(optionalAttribute.isEmpty()){
            throw new Exception("Attribute with id "+attributeId+" is not present");
        }
        Attribute attribute = optionalAttribute.get();
        return attribute.getEntityTypes();
    }

    public List<Attribute> getAttributesOfEntityType(UUID entityTypeId) throws Exception {
        Optional<Entity_Type> optionalEntityType = entityTypeRepository.findById(entityTypeId);
        if(optionalEntityType.isEmpty()){
            throw new Exception("Entity with id "+entityTypeId+" is not present");
        }
        Entity_Type entity_type = optionalEntityType.get();
        return entity_type.getAttributes();
    }
}
