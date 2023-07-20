package com.example.modeleEAV.services;

import com.example.modeleEAV.models.DTO.AttributDTO;
import com.example.modeleEAV.models.DTO.AttributValuesDTO;
import com.example.modeleEAV.models.utilitiesEAV.Attribute;
import com.example.modeleEAV.models.utilitiesEAV.AttributeValue;
import com.example.modeleEAV.repositories.AttributeSetRepository;
import com.example.modeleEAV.repositories.AttributeValuesRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

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

    public void deleteAttributeValues(UUID attributeValuesId) {
        boolean exists = attributeValuesRepository.existsById(attributeValuesId);
        if(!exists){
            throw new IllegalStateException(
                    "AttributeValues with id " + attributeValuesId + " does not exists"
            );
        }
        attributeValuesRepository.deleteById(attributeValuesId);
    }

    @Transactional
    public void updateAttributValues(UUID attributeValuesId, AttributValuesDTO attributValuesDTO) {

        AttributeValue optionalAttributeValues = attributeValuesRepository.findById(attributeValuesId)
                .orElseThrow(() -> new IllegalStateException(
                        "AttributeValues with id " + attributeValuesId + " does not exists"
                ));

        if(optionalAttributeValues.getTitle() != null && optionalAttributeValues.getTitle().length() > 0){
            optionalAttributeValues.setTitle(attributValuesDTO.getTitle());
        }

        if(optionalAttributeValues.getDescription() != null && optionalAttributeValues.getDescription().length() > 0){
            optionalAttributeValues.setDescription(attributValuesDTO.getDescription());
        }

        if(optionalAttributeValues.getValue() != null && optionalAttributeValues.getValue().length() > 0){
            optionalAttributeValues.setValue(attributValuesDTO.getValue());
        }

        if(optionalAttributeValues.getSuffix() != null && optionalAttributeValues.getSuffix().length() > 0){
            optionalAttributeValues.setSuffix(attributValuesDTO.getSuffix());
        }

        if(optionalAttributeValues.getSymbol() != null && optionalAttributeValues.getSymbol().length() > 0){
            optionalAttributeValues.setSymbol(attributValuesDTO.getSymbol());
        }

        if(!optionalAttributeValues.isValidated()){
            optionalAttributeValues.setValidated(attributValuesDTO.isValidated());
        }
    }

    public AttributeValue findAttributeValuesbyTitle(String title) {
        AttributeValue attribut = attributeValuesRepository.findAttributeValuesByTitle(title)
                .orElseThrow(() -> new IllegalStateException(
                        "attributValues with title " + title + " does not exists"
                ));

        return attribut;
    }
}
