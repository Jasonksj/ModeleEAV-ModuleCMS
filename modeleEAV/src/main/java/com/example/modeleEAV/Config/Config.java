package com.example.modeleEAV.Config;

import com.example.modeleEAV.models.utilitiesEAV.Attribute;
import com.example.modeleEAV.models.utilitiesEAV.AttributeSet;
import com.example.modeleEAV.models.utilitiesEAV.AttributeType;
import com.example.modeleEAV.models.utilitiesEAV.AttributeValue;
import com.example.modeleEAV.repositories.AttributeRepository;
import com.example.modeleEAV.repositories.AttributeSetRepository;
import com.example.modeleEAV.repositories.AttributeValuesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class Config {
    @Bean
    CommandLineRunner commandLineRunners(
            AttributeRepository attributeRepository,
            AttributeSetRepository attributeSetRepository,
            AttributeValuesRepository attributeValuesRepository
    ){
        return args -> {

            Attribute attribute1 = new Attribute("Couleur","Couleur du produits", AttributeType.String,false,false,false,false,false,false,false,false);
            Attribute attribute2 = new Attribute("Poids","Poids du produit", AttributeType.Float,true,false,false,false,false,false,false,false);
            Attribute attribute3 = new Attribute("Taille","Taille du produit", AttributeType.Float,false,false,false,false,false,false,false,false);
            Attribute attribute4 = new Attribute("Volume","Volume du produit", AttributeType.Number,false,false,false,false,false,false,false,false);
            //AttributeValue attributeValue7 = new AttributeValue("","","",false,"","");
            Attribute attribute5 = new Attribute("Epaisseur","Epaisseur du produit");
            Attribute attribute6 = new Attribute();
            //attribute4.addValuesInAttribute(attributeValue7);
            attributeRepository.saveAll(List.of(attribute1, attribute2, attribute3, attribute4, attribute5, attribute6));

            AttributeValue attributeValue1 = new AttributeValue("","","");
            AttributeValue attributeValue2 = new AttributeValue("","","",false,"","");
            AttributeValue attributeValue3 = new AttributeValue("",false,"", "");
            AttributeValue attributeValue4 = new AttributeValue("","","");
            AttributeValue attributeValue5 = new AttributeValue("","","");
            AttributeValue attributeValue6 = new AttributeValue("","","");
            AttributeValue attributeValue7 = new AttributeValue();


            attributeValuesRepository.saveAll(List.of(attributeValue1, attributeValue2, attributeValue3, attributeValue4, attributeValue5, attributeValue6));

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
