package com.example.demo.estudiante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {

    private final EstudianteRepository estudianteRepository;

    @Autowired
    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    public List<Estudiante> getEstudiantes() {
        return estudianteRepository.findAll();


    }

    public void addNuevoEstudiante(Estudiante estudiante) {

        Optional<Estudiante> estudiantebyEmail = estudianteRepository.findByEmail(estudiante.getEmail());
        if (estudiantebyEmail.isPresent()) {
            throw new IllegalStateException("Estudiante already exists");
        }
        estudianteRepository.save(estudiante);
    }


    public void deleteEstudiante(Long estudianteId) {
        boolean existe = estudianteRepository.existsById(estudianteId);
        if (!existe) {
            throw new IllegalStateException("Estudiante con id " + estudianteId + " does not exist");
        }

        estudianteRepository.deleteById(estudianteId);

    }
}
