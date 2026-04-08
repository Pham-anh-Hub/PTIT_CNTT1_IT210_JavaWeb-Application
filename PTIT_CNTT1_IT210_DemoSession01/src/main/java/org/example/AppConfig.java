package org.example;

import org.springframework.context.annotation.Bean;

public class AppConfig {

    @Bean
    public Person getNewStudent(){
        Person newPerson = new Person();
        newPerson.setAge(20);
        newPerson.setName("Pham Minh Quan");
        newPerson.setGender(false);
        return newPerson;
    }
}
