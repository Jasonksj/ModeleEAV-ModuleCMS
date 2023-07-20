package com.example.modeleEAV.services;

import com.example.modeleEAV.models.DTO.AttributSetDTO;
import com.example.modeleEAV.models.utilitiesEAV.AttributeSet;
import com.example.modeleEAV.repositories.AttributeSetRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Data
@Service
public class AttributeSetService {
    private final AttributeSetRepository attributeSetRepository;
    @Autowired
    public AttributeSetService(AttributeSetRepository attributeSetRepository){
        this.attributeSetRepository = attributeSetRepository;
    }

    public List<AttributeSet> getAttributeSet() {
        return attributeSetRepository.findAll();
    }

    public void addAttributeSet(AttributeSet attributeSet) {
        attributeSetRepository.save(attributeSet);
    }


    public void deleteAttributeSet(UUID attributeSetId) {
        boolean exists = attributeSetRepository.existsById(attributeSetId);
        if(!exists){
            throw new IllegalStateException(
                    "AttributeSet with id " + attributeSetId + " does not exists"
            );
        }
        attributeSetRepository.deleteById(attributeSetId);
        attributeSetRepository.findAll();
    }

    @Transactional
    public void updateAttributSet(UUID attributeSetId, AttributSetDTO attributSetDTO) {
        AttributeSet attributeSet = attributeSetRepository.findById(attributeSetId)
                .orElseThrow(() -> new IllegalStateException(
                        "AttributSet with id " + attributeSetId + " does not exists"
                ));

        if(attributeSet.getTitle() != null && attributeSet.getTitle().length() > 0 ){
            attributeSet.setTitle(attributSetDTO.getTitle());
        }

        if(attributeSet.getDescription() != null && attributeSet.getDescription().length() > 0 ){
            attributeSet.setDescription(attributSetDTO.getDescription());
        }

        if(attributeSet.getTitleSet() != null && attributeSet.getTitleSet().length() > 0 ){
            attributeSet.setTitleSet(attributSetDTO.getTitleSet());
        }

        if(attributeSet.getDescriptionSet() != null && attributeSet.getDescriptionSet().length() > 0 ){
            attributeSet.setDescriptionSet(attributSetDTO.getDescriptionSet());
        }

        if(!attributeSet.isShareable()){
            attributeSet.setShareable(attributSetDTO.isShareable());
        }

    }

    public AttributeSet findAttributeSetbyTitle(String title) {
        AttributeSet attributSet = attributeSetRepository.findAttributeSetByTitle(title)
                .orElseThrow(() -> new IllegalStateException(
                        "AttributSet with title " + title + " does not exists"
                ));

        return attributSet;
    }

    public AttributeSet findAttributeSetbyId(UUID id) {
        AttributeSet attributSet = attributeSetRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "AttributSet with id " + id + " does not exists"
                ));

        return attributSet;
    }

    public Optional<AttributeSet> findAttributeSetbyAttributId(UUID attributSetId) {
        return attributeSetRepository.findAttributeByAttributSetId(attributSetId);
    }
}
