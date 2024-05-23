package com.example.pr13;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {
    @Value("${program.student.name}")
    private String name;

    @Value("${program.student.surname}")
    private String surname;

    @Value("${program.student.group}")
    private String group;

    @PostConstruct
    public void init() {
        System.out.println(name + " " + surname + " " + group);
    }
}
