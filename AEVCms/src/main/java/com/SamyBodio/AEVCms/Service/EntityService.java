package com.SamyBodio.AEVCms.Service;

import com.SamyBodio.AEVCms.Repository.AttributeRepository;
import com.SamyBodio.AEVCms.Repository.AttributeSetRepository;
import com.SamyBodio.AEVCms.Repository.AttributeValueRepository;
import com.SamyBodio.AEVCms.Repository.UserRepository;
import com.SamyBodio.AEVCms.model.Attribute;
import com.SamyBodio.AEVCms.model.AttributeSet;
import com.SamyBodio.AEVCms.model.AttributeValue;
import com.SamyBodio.AEVCms.model.Entity;
import com.SamyBodio.AEVCms.model.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EntityService {
    private final AttributeValueRepository attributeValueRepository;
    private final AttributeRepository attributeRepository;
    private final AttributeSetRepository attributeSetRepository;
    private final UserRepository userRepository;
    @Autowired
    public EntityService(AttributeValueRepository attributeValueRepository, AttributeRepository attributeRepository, AttributeSetRepository attributeSetRepository, UserRepository userRepository) {
        this.attributeValueRepository = attributeValueRepository;
        this.attributeRepository = attributeRepository;
        this.attributeSetRepository = attributeSetRepository;
        this.userRepository = userRepository;
    }

    public void CreateAttributes(User user, Attribute attribute,AttributeValue attributeValue) {
        userRepository.save(user);
        attribute.setUser(user);
        attribute.setCreateBy(user);
        attribute.setUpdateBy(user);
        attribute.setDeleteBy(user);
        attributeValue.setCreateBy(user);
        attributeValue.setUpdateBy(user);
        attributeValue.setDeleteBy(user);
        attributeValueRepository.save(attributeValue);
        attribute.addPredifinedValues(attributeValue);
        attributeRepository.save(attribute);
    }

    public List<Attribute> getAttributes() {
        return attributeRepository.findAll();
    }

    public List<Attribute> SearchAttributes(String str) {
        return attributeRepository.findAll().stream().filter(S->{
            return S.getTitle().contains(str) || S.getDescription().contains(str)
                    || S.getUser().toString().contains(str) || S.getCreateBy().toString().contains(str);
        }).collect(Collectors.toList());
    }
    @Transactional
    public void DeleteAttributes(String str) {
        Optional<Attribute> attributeOptional = attributeRepository.getAttributeByTitle(str);
        if(attributeOptional.isEmpty()) {
            throw new IllegalStateException(
                    "Attribute with title "+str+" does not exists"
            );
        }
        attributeRepository.deleteAttributeByTitle(str);
    }

    public List<AttributeValue> getAttributesValues(String titleAttribute) {
        Optional<Attribute> optionalAttribute = attributeRepository.getAttributeByTitle(titleAttribute);
        if(optionalAttribute.isEmpty()){
            throw new IllegalStateException("Attribute with title "+titleAttribute+" does not exists");
        }
        return optionalAttribute.get().getDefinedValues();
    }
    @Transactional
    public void updateAttribute(Attribute attribute, String title) {
        Optional<Attribute> optionalAttribute = attributeRepository.getAttributeByTitle(title);
        if(optionalAttribute.isEmpty()){
            throw new IllegalStateException("Attribute with title "+title+" does not exists");
        }
        Attribute attribute1 = optionalAttribute.get();
        attribute.setUpdateAt(LocalDate.now());
        attribute.setHerited(attribute1.getHerited());
        attribute.setDeleteAt(attribute1.getDeleteAt());
        attribute.setDefinedValues(attribute1.getDefinedValues());
        attribute.setFreezeValues(attribute1.getFreezeValues());
        attribute.setMultipleValues(attribute1.getMultipleValues());
        attribute.setMeasurable(attribute1.getMeasurable());
        attribute.setRequiredValue(attribute1.getRequiredValue());
        attribute.setOverriden(attribute1.getOverriden());
        attribute.setType(attribute1.getType());
        attribute.setTitle(attribute1.getTitle());
        attribute.setDescription(attribute1.getDescription());
        attribute.setShared(attribute1.getShared());
    }

    @Transactional
    public void addEntityInAttribute(String str, List<Entity> entity) {
        Optional<Attribute> Opt = attributeRepository.getAttributeByTitle(str);
        if(Opt.isEmpty()){
            throw new IllegalStateException("Attribute with title "+str+" does not exists");
        }
        Attribute attribute = Opt.get();
        System.out.println(entity);
        Boolean bool = attribute.getEntities().addAll(entity);
        System.out.println(bool+"......................................................................................................................");
       // attributeRepository.save();
        attributeRepository.saveAndFlush(attribute);
    }

    public List<Entity> getEntityInAttribute(UUID str) {
        Optional<Attribute> Opt = attributeRepository.findById(str);
        if(Opt.isEmpty()){
            throw new IllegalStateException("Attribute with title "+str+" does not exists");
        }
        return Opt.get().getEntities();
    }

    public void createAttributeSet(AttributeSet attrSet) {
        attributeSetRepository.save(attrSet);
    }

    public void deleteAttributeSet(UUID attrSet) {
    }

    public void updateAttributeSet(UUID attrSet) {
    }

    public List<AttributeSet> getAllAttributeSet(UUID attrSet) {
    }

    public AttributeSet getAttributeSetInfo(UUID attrSet) {
    }

    public List<Attribute> getAttributeSetAttributes(UUID attrSet) {
    }

    public List<Entity> getEntitiesOfAttribute(UUID entity) {
    }

    public void addAttrInEntity(UUID entity) {
    }

    public void deleteAttrInEntity(UUID entity) {
    }

    public List<Attribute> getAttributesOfEntity(UUID entity) {
    }
}
