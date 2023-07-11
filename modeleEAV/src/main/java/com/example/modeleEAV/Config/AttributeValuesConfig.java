package com.example.modeleEAV.Config;

import com.example.modeleEAV.models.utilitiesEAV.Attribute;
import com.example.modeleEAV.models.utilitiesEAV.AttributeType;
import com.example.modeleEAV.models.utilitiesEAV.AttributeValue;
import com.example.modeleEAV.repositories.AttributeRepository;
import com.example.modeleEAV.repositories.AttributeValuesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AttributeValuesConfig {
    @Bean
    CommandLineRunner commandLineRunnersValues(
            AttributeValuesRepository attributeValuesRepository
    ){
        return args -> {

            AttributeValue attributeValue1 = new AttributeValue("","","");
            AttributeValue attributeValue2 = new AttributeValue("","","",false,"","");
            AttributeValue attributeValue3 = new AttributeValue();
            AttributeValue attributeValue4 = new AttributeValue("","","");
            AttributeValue attributeValue5 = new AttributeValue("","","");
            AttributeValue attributeValue6 = new AttributeValue("","","");

            attributeValuesRepository.saveAll(List.of(attributeValue1, attributeValue2, attributeValue3, attributeValue4, attributeValue5, attributeValue6));
        };
    }
}
