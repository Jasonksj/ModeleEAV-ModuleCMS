package com.example.modeleEAV.services;

import com.example.modeleEAV.models.utilitiesEAV.AttributeSet;
import com.example.modeleEAV.repositories.AttributeSetRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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


    public void deleteAttributeSet(Long attributeSetId) {
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
    public void updateAttributSet(Long attributeSetId, String title, String description, String titleSet, String descriptionSet, boolean shareable) {
        AttributeSet attributeSet = attributeSetRepository.findById(attributeSetId)
                .orElseThrow(() -> new IllegalStateException(
                        "AttributSet with id " + attributeSetId + " does not exists"
                ));
        if(title != null && title.length() > 0 && !Objects.equals(attributeSet.getTitle(), title)){
            attributeSet.setTitle(title);
        }

        if(description != null && description.length() > 0 && !Objects.equals(attributeSet.getDescription(), description)){
            attributeSet.setDescription(description);
        }

        if(titleSet != null && titleSet.length() > 0 && !Objects.equals(attributeSet.getTitleSet(), titleSet)){
            attributeSet.setTitleSet(titleSet);
        }

        if(descriptionSet != null && descriptionSet.length() > 0 && !Objects.equals(attributeSet.getDescriptionSet(), descriptionSet)){
            attributeSet.setDescriptionSet(descriptionSet);
        }

        if(!attributeSet.isShareable()){
            attributeSet.setShareable(shareable);
        }

        attributeSetRepository.findAll();
    }

    public AttributeSet findAttributeSetbyTitle(String title) {
        AttributeSet attributSet = attributeSetRepository.findAttributeSetByTitle(title)
                .orElseThrow(() -> new IllegalStateException(
                        "AttributSet with title " + title + " does not exists"
                ));

        return attributSet;
    }

    public AttributeSet findAttributeSetbyId(Long id) {
        AttributeSet attributSet = attributeSetRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "AttributSet with id " + id + " does not exists"
                ));

        return attributSet;
    }

    public Optional<AttributeSet> findAttributeSetbyAttributId(Long attributSetId) {
        return attributeSetRepository.findAttributeByAttributSetId(attributSetId);
    }
}
