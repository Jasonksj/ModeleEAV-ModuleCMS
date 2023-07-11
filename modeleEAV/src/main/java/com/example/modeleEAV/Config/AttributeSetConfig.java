package com.example.modeleEAV.Config;

import com.example.modeleEAV.models.utilitiesEAV.Attribute;
import com.example.modeleEAV.models.utilitiesEAV.AttributeSet;
import com.example.modeleEAV.models.utilitiesEAV.AttributeType;
import com.example.modeleEAV.repositories.AttributeRepository;
import com.example.modeleEAV.repositories.AttributeSetRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class AttributeSetConfig {
    @Bean
    CommandLineRunner commandLineRunnersSet(
            AttributeSetRepository attributeSetRepository
    ){
        return args -> {
            Attribute attribute7 = new Attribute("Volume","Volume du produit", AttributeType.Number,false,false,false,false,false,false,false,false);
            Attribute attribute8 = new Attribute("Epaisseur","Epaisseur du produit");
            AttributeSet attributeSet1 = new AttributeSet("","","","",false,new ArrayList<>());
            attribute7.setAttributeSet(attributeSet1);
            attribute8.setAttributeSet(attributeSet1);
            attributeSet1.setAttributes(Arrays.asList(
                    attribute7,attribute8
            ));

            AttributeSet attributeSet2 = new AttributeSet("","",false,new ArrayList<>());
            AttributeSet attributeSet3 = new AttributeSet();
            AttributeSet attributeSet4 = new AttributeSet("","","","",false,new ArrayList<>());
            AttributeSet attributeSet5 = new AttributeSet("","",false,new ArrayList<>());
            AttributeSet attributeSet6 = new AttributeSet();

            attributeSetRepository.saveAll(List.of(attributeSet1, attributeSet2, attributeSet3, attributeSet4, attributeSet5, attributeSet6));
        };
    }
}
