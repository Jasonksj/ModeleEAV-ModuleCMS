package com.example.modeleEAV.services;

import com.example.modeleEAV.repositories.AttributeSetRepository;
import com.example.modeleEAV.repositories.AttributeValuesRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class AttributValuesService {
    private AttributeValuesRepository attributeValuesRepository;

    @Autowired
    public AttributValuesService(AttributeValuesRepository attributeValuesRepository){
        this.attributeValuesRepository = attributeValuesRepository;
    }
}
