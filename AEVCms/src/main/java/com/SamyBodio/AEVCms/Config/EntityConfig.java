package com.SamyBodio.AEVCms.Config;


import com.SamyBodio.AEVCms.Repository.AttributeRepository;
import com.SamyBodio.AEVCms.Repository.UserRepository;
import com.SamyBodio.AEVCms.model.Attribute;
import com.SamyBodio.AEVCms.model.AttributeType;
import com.SamyBodio.AEVCms.model.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class EntityConfig {
    @Bean
    CommandLineRunner commandLineRunner(AttributeRepository attributeRepository, UserRepository userRepository) {
        return args -> {
            User user = new User("samy","rzm237");
            userRepository.save(user);
            Attribute attribute = new Attribute("slug","title","description",
                    user,user,user, AttributeType.String,false,true,false,false);
            attributeRepository.save(attribute);
        };
    }
}
