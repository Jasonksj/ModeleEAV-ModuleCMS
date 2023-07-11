package com.example.modeleEAV.models.Test;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunnersConfig(
            UserRepository userRepository
    ){
        return args -> {

            Customer customer1 = new Customer("client1");
            Customer customer2 = new Customer("client2");
            User user1 = new User("users1","users1@gmail.com");
            customer1.setUser(user1);
            customer2.setUser(user1);
            user1.setCustomers(Arrays.asList(
                    customer1,
                    customer2
            ));

            Customer customer3 = new Customer("client3");
            Customer customer4 = new Customer("client4");
            User user2 = new User("users2", "users2@gmail.com");
            customer3.setUser(user2);
            customer4.setUser(user2);
            user2.setCustomers(Arrays.asList(
                    customer3,
                    customer4
            ));

            Customer customer5 = new Customer("client5");
            Customer customer6 = new Customer("client6");
            User user3 = new User("users3", "users3@gmail.com" );
            customer5.setUser(user3);
            customer6.setUser(user3);
            user3.setCustomers(Arrays.asList(
                    customer6,
                    customer5
            ));

            User user = new User();


            userRepository.saveAll(List.of(user1, user2, user3, user));
        };
    }
}

