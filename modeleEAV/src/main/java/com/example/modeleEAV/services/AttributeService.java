package com.example.modeleEAV.services;

import com.example.modeleEAV.models.utilitiesEAV.Attribute;
import com.example.modeleEAV.models.utilitiesEAV.AttributeType;
import com.example.modeleEAV.repositories.AttributeRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Data
@Service
public class AttributeService {
    private final AttributeRepository attributeRepository;
    @Autowired
    public AttributeService(AttributeRepository attributeRepository){
        this.attributeRepository = attributeRepository;
    }

    public List<Attribute> getAttributes(){
        return attributeRepository.findAll();
    }

    public void addAttribute(Attribute attribute){
        attributeRepository.save(attribute);
    }

    public void deleteAttribute(Long attributeId) {
        boolean exists = attributeRepository.existsById(attributeId);
        if(!exists){
            throw new IllegalStateException(
                    "Attribute with id " + attributeId + " does not exists"
            );
        }
        attributeRepository.deleteById(attributeId);
        attributeRepository.findAll();
    }

    @Transactional
    public void updateAttribut(Long attributId, String title, String description,
                              AttributeType type, boolean requiredValue,
                              boolean multipleValues, boolean freezeValues,
                              boolean overriden, boolean shareable,
                              boolean shared, boolean measurable,
                              boolean isEntityDedicated) {

        Attribute attribute = attributeRepository.findById(attributId)
                .orElseThrow(() -> new IllegalStateException(
                        "Attribute with id " + attributId + " does not exists"
                ));

        if(title != null && title.length() > 0 && !Objects.equals(attribute.getTitle(), title)){
            attribute.setTitle(title);
        }

        if(description != null && description.length() > 0 && !Objects.equals(attribute.getDescription(), description)){
            attribute.setDescription(description);
        }

        if(type != null && !Objects.equals(attribute.getType(), type)){
            attribute.setType(type);
        }
        if(!attribute.isMultipleValues()){
            attribute.setMultipleValues(multipleValues);
        }
        if(!attribute.isFreezeValues()){
            attribute.setFreezeValues(freezeValues);
        }
        if(!attribute.isOverriden()){
            attribute.setOverriden(overriden);
        }
        if(!attribute.isShareable()){
            attribute.setShareable(shareable);
        }
        if(!attribute.isShared()){
            attribute.setShared(shared);
        }
        if(!attribute.isMeasurable()){
            attribute.setMeasurable(measurable);
        }
        if(!attribute.isEntityDedicated()){
            attribute.setEntityDedicated(isEntityDedicated);
        }
        attributeRepository.findAll();
    }

    public Attribute findAttributebyTitle(String title) {
        Attribute attribut = attributeRepository.findAttributeByTitle(title)
                .orElseThrow(() -> new IllegalStateException(
                        "attribut with title " + title + " does not exists"
                ));

        return attribut;
    }

    public Attribute findAttributebyId(Long attributeId) {
        Attribute attribut = attributeRepository.findById(attributeId)
                .orElseThrow(() -> new IllegalStateException(
                        "attribut with id " + attributeId + " does not exists"
                ));

        return attribut;
    }

    public List<Attribute> getAttributesByAttributeSetId(Long attributeSetId) {

        List<Attribute> attributes =  attributeRepository.findByAttributeSetId(attributeSetId)
                .orElseThrow(() -> new IllegalStateException(
                        "No attributSet"
                ));

        return attributes;
    }
}
