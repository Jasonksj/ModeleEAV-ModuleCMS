package com.example.modeleEAV.services;

import com.example.modeleEAV.models.DTO.AttributDTO;
import com.example.modeleEAV.models.utilitiesEAV.Attribute;
import com.example.modeleEAV.models.utilitiesEAV.AttributeType;
import com.example.modeleEAV.repositories.AttributeRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

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

    public List<Attribute> SearchAttributes(String str) {
        return attributeRepository.findAll().stream().filter(S->{
            return S.getTitle().contains(str) || S.getDescription().contains(str);
        }).collect(Collectors.toList());
    }

    public void addAttribute(Attribute attribute){
        attributeRepository.save(attribute);
    }

    public void deleteAttribute(UUID attributeId) {
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
    public void updateAttribut(UUID attributId, AttributDTO attributDTO) {

        Attribute optionalAttribute = attributeRepository.findById(attributId)
                .orElseThrow(() -> new IllegalStateException(
                        "Attribute with id " + attributId + " does not exists"
                ));

        if(optionalAttribute.getTitle() != null && optionalAttribute.getTitle().length() > 0){
            optionalAttribute.setTitle(attributDTO.getTitle());
        }

        if(optionalAttribute.getDescription() != null && optionalAttribute.getDescription().length() > 0){
            optionalAttribute.setDescription(attributDTO.getDescription());
        }

        if(optionalAttribute.getType() != null){
            optionalAttribute.setType(attributDTO.getType());
        }
        if(!optionalAttribute.isMultipleValues()){
            optionalAttribute.setMultipleValues(attributDTO.isMultipleValues());
        }
        if(!optionalAttribute.isFreezeValues()){
            optionalAttribute.setFreezeValues(attributDTO.isFreezeValues());
        }
        if(!optionalAttribute.isOverriden()){
            optionalAttribute.setOverriden(attributDTO.isOverriden());
        }
        if(!optionalAttribute.isShareable()){
            optionalAttribute.setShareable(attributDTO.isShareable());
        }
        if(!optionalAttribute.isShared()){
            optionalAttribute.setShared(attributDTO.isShared());
        }
        if(!optionalAttribute.isMeasurable()){
            optionalAttribute.setMeasurable(attributDTO.isMeasurable());
        }
        if(!optionalAttribute.isEntityDedicated()){
            optionalAttribute.setEntityDedicated(attributDTO.isEntityDedicated());
        }
    }

    public Attribute findAttributebyTitle(String title) {
        Attribute attribut = attributeRepository.findAttributeByTitle(title)
                .orElseThrow(() -> new IllegalStateException(
                        "attribut with title " + title + " does not exists"
                ));

        return attribut;
    }

    public Attribute findAttributebyId(UUID attributeId) {
        Attribute attribut = attributeRepository.findById(attributeId)
                .orElseThrow(() -> new IllegalStateException(
                        "attribut with id " + attributeId + " does not exists"
                ));

        return attribut;
    }

    public List<Attribute> getAttributesByAttributeSetId(UUID attributeSetId) {

        List<Attribute> attributes =  attributeRepository.findByAttributeSetId(attributeSetId)
                .orElseThrow(() -> new IllegalStateException(
                        "No attributSet"
                ));

        return attributes;
    }

    public List<Attribute> findAttributByTitle() {
        List<Attribute> attributes = attributeRepository.findAttributeByTitle();
        return attributes;
    }
}
