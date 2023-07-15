package com.example.modeleEAV.services;

import com.example.modeleEAV.models.utilitiesEAV.Attribute;
import com.example.modeleEAV.models.utilitiesEAV.AttributeValue;
import com.example.modeleEAV.repositories.AttributeSetRepository;
import com.example.modeleEAV.repositories.AttributeValuesRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class AttributValuesService {
    private AttributeValuesRepository attributeValuesRepository;

    @Autowired
    public AttributValuesService(AttributeValuesRepository attributeValuesRepository){
        this.attributeValuesRepository = attributeValuesRepository;
    }

    public List<AttributeValue> getAttributeValues() {
        return attributeValuesRepository.findAll();
    }

    public void addAttributeValues(AttributeValue attributeValue){
        attributeValuesRepository.save(attributeValue);
    }

}
