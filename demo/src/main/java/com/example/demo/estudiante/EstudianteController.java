package com.example.demo.estudiante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/Estudiante")
public class EstudianteController {

    private final EstudianteService estudianteService;

    @Autowired
    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping
    public List<Estudiante> getEstudiantes() {
        return estudianteService.getEstudiantes();

    }

    @PostMapping
    public void RegistroNuevoEstudiante(@RequestBody Estudiante estudiante) {
        estudianteService.addNuevoEstudiante(estudiante);
    }

    @DeleteMapping(path = "{estudianteId}")
    public void deleteEstudiante(@PathVariable("estudianteId") Long estudianteId) {
        estudianteService.deleteEstudiante(estudianteId);
    }

}
