package com.example.modeleEAV.Config;

import com.example.modeleEAV.models.utilitiesEAV.Attribute;
import com.example.modeleEAV.models.utilitiesEAV.AttributeType;
import com.example.modeleEAV.models.utilitiesEAV.AttributeValue;
import com.example.modeleEAV.repositories.AttributeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AttributeConfig {
    @Bean
    CommandLineRunner commandLineRunners(
            AttributeRepository attributeRepository
    ){
        return args -> {

            Attribute attribute1 = new Attribute("Couleur","Couleur du produits", AttributeType.String,false,false,false,false,false,false,false,false);
            Attribute attribute2 = new Attribute("Poids","Poids du produit", AttributeType.Float,true,false,false,false,false,false,false,false);
            Attribute attribute3 = new Attribute("Taille","Taille du produit", AttributeType.Float,false,false,false,false,false,false,false,false);
            Attribute attribute4 = new Attribute("Volume","Volume du produit", AttributeType.Number,false,false,false,false,false,false,false,false);
            Attribute attribute5 = new Attribute("Epaisseur","Epaisseur du produit");
            Attribute attribute6 = new Attribute();

            attributeRepository.saveAll(List.of(attribute1, attribute2, attribute3, attribute4, attribute5, attribute6));
        };
    }
}
