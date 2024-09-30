package com.example.demo.estudiante;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class EstudianteConfig {

    @Bean
    CommandLineRunner commandLineRunner(EstudianteRepository Repository) {
        return args -> {
            Estudiante Fernando = new Estudiante("Fernando", "FerAlo@gmail.com", LocalDate.of(1982, Month.OCTOBER, 10));
            Estudiante Alex = new Estudiante("Alex", "FerAle@gmail.com", LocalDate.of(1982, Month.OCTOBER, 10));
            Estudiante Erika = new Estudiante("Erika", "ErikaRos@gmail.com", LocalDate.of(2001, Month.SEPTEMBER, 11));

            Repository.saveAll(List.of(Fernando, Alex, Erika));
        };
    }
}
