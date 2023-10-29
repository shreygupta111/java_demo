package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student mariam = new Student(
                    "Mariam",
                    LocalDate.of(2004, Month.JANUARY, 24),
                    "maria@gmail.com"
            );
            Student alex = new Student(
                    "Alex",
                    LocalDate.of(2006, Month.JANUARY, 22),
                    "alex@gmail.com"
            );
            repository.saveAll(List.of(mariam, alex));
        };
    }
}
